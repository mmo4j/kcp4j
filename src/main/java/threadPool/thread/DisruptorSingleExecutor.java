package threadpool.thread;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.WaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

import threadpool.task.ITask;

/**
 * 基于 {@link #disruptor} 的单线程队列实现
 *
 * @author King
 */
public class DisruptorSingleExecutor implements IMessageExecutor {

  private static final DistriptorEventHandler handler = new DistriptorEventHandler();
  static int num = 1;
  static long start = System.currentTimeMillis();
  static long lastNum = 0;
  //65536条消息
  int ringBufferSize = 2 << 15;
  private WaitStrategy strategy = new BlockingWaitStrategy();
  private Disruptor<DistriptorHandler> disruptor = null;
  private RingBuffer<DistriptorHandler> buffer = null;
  private DistriptorEventFactory eventFactory = new DistriptorEventFactory();
  private AtomicBoolean istop = new AtomicBoolean();
  /**
   * 线程名字
   **/
  private String threadName;
  private DisruptorThread currentThread;

  public DisruptorSingleExecutor(String threadName) {
    this.threadName = threadName;
  }

  public static void main(String[] args) {
    DisruptorSingleExecutor disruptorSingleExecutor = new DisruptorSingleExecutor("aa");
    disruptorSingleExecutor.start();
    disruptorSingleExecutor.execute(() -> {
      System.out.println("hahaha");
    });

    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }


  }

  @SuppressWarnings("unchecked")
  public void start() {
    LoopThreadfactory loopThreadfactory = new LoopThreadfactory(this);
//		disruptor = new Disruptor<DistriptorHandler>(eventFactory, ringBufferSize, executor, ProducerType.MULTI, strategy);
    disruptor = new Disruptor<>(eventFactory, ringBufferSize, loopThreadfactory);
    buffer = disruptor.getRingBuffer();
    disruptor.handleEventsWith(DisruptorSingleExecutor.handler);
    disruptor.start();
  }

  public void stop() {
    if (istop.get()) {
      return;
    }
    disruptor.shutdown();

    istop.set(true);
  }

  public AtomicBoolean getIstop() {
    return istop;
  }

  public boolean isFull() {
    return !buffer.hasAvailableCapacity(1);
  }

  @Override
  public void execute(ITask iTask) {
    Thread currentThread = Thread.currentThread();
    if (currentThread == this.currentThread) {
      iTask.execute();
      return;
    }
    //		if(buffer.hasAvailableCapacity(1))
//		{
//			System.out.println("没有容量了");
//		}
    long next = buffer.next();
    DistriptorHandler testEvent = buffer.get(next);
    testEvent.setTask(iTask);
    buffer.publish(next);
  }

  /**
   * 主线程工厂
   **/
  private class LoopThreadfactory implements ThreadFactory {

    IMessageExecutor iMessageExecutor;

    public LoopThreadfactory(IMessageExecutor iMessageExecutor) {
      this.iMessageExecutor = iMessageExecutor;
    }

    public Thread newThread(Runnable r) {
      currentThread = new DisruptorThread(r, iMessageExecutor);
      currentThread.setName(threadName);
      return currentThread;
    }
  }
}
