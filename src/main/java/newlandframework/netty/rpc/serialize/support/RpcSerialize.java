package newlandframework.netty.rpc.serialize.support;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * RPC消息序列化/反序列化接口定义
 * Created by dy on 2016/12/24.
 */
public interface RpcSerialize {

    void serialize(OutputStream output, Object object) throws IOException;

    Object deserialize(InputStream input) throws IOException;
}
