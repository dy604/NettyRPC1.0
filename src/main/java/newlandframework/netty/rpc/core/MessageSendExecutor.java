package newlandframework.netty.rpc.core;

import com.google.common.reflect.Reflection;
import newlandframework.netty.rpc.serialize.support.RpcSerializeProtocol;

/**
 * RPC客户端执行模块
 * Created by dy on 2016/12/23.
 */
public class MessageSendExecutor {

    private RpcServerLoader  loader = RpcServerLoader.getInstance();

    public MessageSendExecutor() {
    }

    public MessageSendExecutor(String serverAddress, RpcSerializeProtocol serializeProtocol) {
        loader.load(serverAddress, serializeProtocol);
    }

    public void setRpcServerLoader(String serverAddress, RpcSerializeProtocol serializeProtocol) {
        loader.load(serverAddress, serializeProtocol);
    }

    public void stop() {
        loader.unLoad();
    }

    /**
     * RPC客户端实际上是动态代理了MessageSendProxy，应用了JDK原生的动态代理实现
     * @param rpcInterface
     * @param <T>
     * @return
     */
    public static <T> T execute(Class<T> rpcInterface) {
        return (T) Reflection.newProxy(rpcInterface, new MessageSendProxy<T>());
    }
}
