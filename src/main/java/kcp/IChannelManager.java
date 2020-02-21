package kcp;

import java.net.SocketAddress;
import java.util.Collection;

import io.netty.channel.socket.DatagramPacket;

/**
 * Created by JinMiao
 * 2019/10/16.
 */
public interface IChannelManager {

  Ukcp get(DatagramPacket msg);

  void add(SocketAddress socketAddress, Ukcp ukcp);

  void remove(Ukcp ukcp);

  Collection<Ukcp> getAll();
}
