package newlandframework.netty.rpc.serialize.support;

import io.netty.buffer.ByteBuf;

import java.io.IOException;

/**
 * RPC消息编解码接口
 * Created by dy on 2016/12/24.
 */
public interface MessageCodecUtil {

    final public static int MESSAGE_LENGTH = 4;

    public void encode(final ByteBuf out, final Object message) throws IOException;

    public Object decode(byte[] body) throws IOException;
}
