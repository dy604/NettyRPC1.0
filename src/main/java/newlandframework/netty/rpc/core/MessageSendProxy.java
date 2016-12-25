package newlandframework.netty.rpc.core;

import com.google.common.reflect.AbstractInvocationHandler;
import newlandframework.netty.rpc.model.MessageRequest;

import java.lang.reflect.Method;
import java.util.UUID;

/**
 * RPC客户端消息处理
 * Created by dy on 2016/12/24.
 */
public class MessageSendProxy<T> extends AbstractInvocationHandler {

    @Override
    protected Object handleInvocation(Object proxy, Method method, Object[] args) throws Throwable {
        MessageRequest request = new MessageRequest();
        request.setMessageId(UUID.randomUUID().toString());
        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());
        request.setTypeParameters(method.getParameterTypes());
        request.setParametersVal(args);

        /**
         * MessageSendProxy其实是把消息发送给RpcServerLoader模块
         */
        MessageSendHandler handler = RpcServerLoader.getInstance().getMessageSendHandler();
        MessageCallBack callBack = handler.sendRequest(request);
        return callBack.start();
    }
}
