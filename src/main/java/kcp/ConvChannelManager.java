package kcp;

import java.net.SocketAddress;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import io.netty.buffer.ByteBuf;
import io.netty.channel.socket.DatagramPacket;

/**
 * 根据conv确定一个session
 * Created by JinMiao
 * 2019/10/17.
 */
public class ConvChannelManager implements IChannelManager {

  private int convIndex;
  private Map<Integer, Ukcp> ukcpMap = new ConcurrentHashMap<>();

  public ConvChannelManager(int convIndex) {
    this.convIndex = convIndex;
  }

  @Override
  public Ukcp get(DatagramPacket msg) {
    ByteBuf byteBuf = msg.content();
    int conv = byteBuf.getInt(byteBuf.readerIndex() + convIndex);
    return ukcpMap.get(conv);
  }

  @Override
  public void add(SocketAddress socketAddress, Ukcp ukcp) {
    ukcpMap.put(ukcp.getConv(), ukcp);
  }

  @Override
  public void remove(Ukcp ukcp) {
    ukcpMap.remove(ukcp.getConv());
  }

  @Override
  public Collection<Ukcp> getAll() {
    return this.ukcpMap.values();
  }
}
