package newlandframework.netty.rpc.core;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import newlandframework.netty.rpc.serialize.support.RpcSerializeProtocol;

/**
 * RPC客户端管道初始化
 * Created by dy on 2016/12/24.
 */
public class MessageSendChannelInitializer extends ChannelInitializer<SocketChannel> {

    private RpcSerializeProtocol protocol;
    private RpcSendSerializeFrame frame = new RpcSendSerializeFrame();

    MessageSendChannelInitializer buildRpcSerializeProtocol(RpcSerializeProtocol protocol) {
        this.protocol = protocol;
        return this;
    }

    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        //序列化协议选择与管道初始化，客户端和服务端的协议类型必须一致，才能互相通信。
        frame.select(protocol, pipeline);
    }
}
