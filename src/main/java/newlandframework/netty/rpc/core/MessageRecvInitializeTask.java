package newlandframework.netty.rpc.core;

import io.netty.channel.ChannelHandlerContext;
import newlandframework.netty.rpc.model.MessageRequest;
import newlandframework.netty.rpc.model.MessageResponse;
import org.apache.commons.lang3.reflect.MethodUtils;

import java.util.Map;
import java.util.concurrent.Callable;

/**
 * RPC服务器消息线程任务处理
 * Created by dy on 2016/12/24.
 */
public class MessageRecvInitializeTask implements Callable<Boolean> {

    private MessageRequest request = null;
    private MessageResponse response = null;
    private Map<String, Object> handlerMap = null;
    private ChannelHandlerContext ctx = null;

    public MessageRequest getRequest() {
        return request;
    }

    public MessageResponse getResponse() {
        return response;
    }

    public void setRequest(MessageRequest request) {
        this.request = request;
    }

    MessageRecvInitializeTask(MessageRequest request, MessageResponse response, Map<String, Object> handlerMap) {
        this.request = request;
        this.response = response;
        this.handlerMap = handlerMap;
        //this.ctx = ctx;
    }

    /**
     * 将反射计算结果写入到RPC应答报文结构中
     * @return
     */
    public Boolean call() {
        response.setMessageId(request.getMessageId());
        try {
            Object result = reflect(request);
            response.setResult(result);
            return Boolean.TRUE;
        } catch (Throwable t) {
            response.setError(t.toString());
            t.printStackTrace();
            System.err.printf("RPC Server invoke error!\n");
            return Boolean.FALSE;
        }
    }

    /**
     * 根据RPC消息的请求报文，利用反射得到最终的计算结果
     * @param request
     * @return
     * @throws Throwable
     */
    private Object reflect(MessageRequest request) throws Throwable {
        String className = request.getClassName();
        Object serviceBean = handlerMap.get(className);
        String methodName = request.getMethodName();
        Object[] parameters = request.getParametersVal();
        return MethodUtils.invokeMethod(serviceBean, methodName, parameters);
    }
}
