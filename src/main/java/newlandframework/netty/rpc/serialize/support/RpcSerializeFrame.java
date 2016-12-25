package newlandframework.netty.rpc.serialize.support;

import io.netty.channel.ChannelPipeline;

/**
 * Created by dy on 2016/12/24.
 */
public interface RpcSerializeFrame {

    public void select(RpcSerializeProtocol protocol, ChannelPipeline pipeline);
}
