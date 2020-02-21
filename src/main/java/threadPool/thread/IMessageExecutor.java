package threadpool.thread;

import threadpool.task.ITask;

/**
 * 消息处理器
 */
public interface IMessageExecutor {

  /**
   * 启动消息处理器
   */
  void start();

  /**
   * 停止消息处理器
   */
  void stop();

  /**
   * 判断队列是否已经达到上限了
   */
  boolean isFull();

  /**
   * 执行任务
   * 注意: 如果线程等于当前线程 则直接执行  如果非当前线程放进队列
   */
  void execute(ITask iTask);
}
