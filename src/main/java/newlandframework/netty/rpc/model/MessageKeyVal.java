package newlandframework.netty.rpc.model;

import java.util.Map;

/**
 * RPC服务映射容器
 * Created by dy on 2016/12/23.
 */
public class MessageKeyVal {

    private Map<String, Object> messageKeyVal;

    public Map<String, Object> getMessageKeyVal() {
        return messageKeyVal;
    }

    public void setMessageKeyVal(Map<String, Object> messageKeyVal) {
        this.messageKeyVal = messageKeyVal;
    }
}
