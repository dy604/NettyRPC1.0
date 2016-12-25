package newlandframework.netty.rpc.core;

import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ObjectEncoder;
import newlandframework.netty.rpc.serialize.support.MessageCodecUtil;
import newlandframework.netty.rpc.serialize.support.RpcSerializeFrame;
import newlandframework.netty.rpc.serialize.support.RpcSerializeProtocol;
import newlandframework.netty.rpc.serialize.support.hessian.HessianCodecUtil;
import newlandframework.netty.rpc.serialize.support.hessian.HessianDecoder;
import newlandframework.netty.rpc.serialize.support.hessian.HessianEncoder;
import newlandframework.netty.rpc.serialize.support.kryo.KryoCodecUtil;
import newlandframework.netty.rpc.serialize.support.kryo.KryoDecoder;
import newlandframework.netty.rpc.serialize.support.kryo.KryoEncoder;
import newlandframework.netty.rpc.serialize.support.kryo.KryoPoolFactory;

/**
 * RPC客户端消息序列化协议框架
 * Created by dy on 2016/12/24.
 */
public class RpcSendSerializeFrame implements RpcSerializeFrame {

    //后续可以优化成通过Spring IOC方式注入的
    @Override
    public void select(RpcSerializeProtocol protocol, ChannelPipeline pipeline) {
        switch (protocol) {
            case JDKSERIALIZE: {
                pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, MessageCodecUtil.MESSAGE_LENGTH, 0, MessageCodecUtil.MESSAGE_LENGTH));
                pipeline.addLast(new LengthFieldPrepender(MessageCodecUtil.MESSAGE_LENGTH));
                pipeline.addLast(new ObjectEncoder());
                pipeline.addLast(new MessageSendHandler());
                break;
            }
            case KRYOSERIALIZE: {
                KryoCodecUtil util = new KryoCodecUtil(KryoPoolFactory.getKryoPoolInstance());
                pipeline.addLast(new KryoEncoder(util));
                pipeline.addLast(new KryoDecoder(util));
                pipeline.addLast(new MessageSendHandler());
                break;
            }
            case HESSIANSERIALIZE: {
                HessianCodecUtil util = new HessianCodecUtil();
                pipeline.addLast(new HessianEncoder(util));
                pipeline.addLast(new HessianDecoder(util));
                pipeline.addLast(new MessageSendHandler());
                break;
            }
        }
    }
}
