package newlandframework.netty.rpc.serialize.support.kryo;

import newlandframework.netty.rpc.serialize.support.MessageCodecUtil;
import newlandframework.netty.rpc.serialize.support.MessageEncoder;

/**
 * Kryo编码器
 * Created by dy on 2016/12/24.
 */
public class KryoEncoder extends MessageEncoder {

    public KryoEncoder(MessageCodecUtil util) {
        super(util);
    }
}
