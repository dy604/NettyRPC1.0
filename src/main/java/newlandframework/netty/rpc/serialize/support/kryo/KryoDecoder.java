package newlandframework.netty.rpc.serialize.support.kryo;

import newlandframework.netty.rpc.serialize.support.MessageCodecUtil;
import newlandframework.netty.rpc.serialize.support.MessageDecoder;

/**
 * Kryo解码器
 * Created by dy on 2016/12/24.
 */
public class KryoDecoder extends MessageDecoder {

    public KryoDecoder(MessageCodecUtil util) {
        super(util);
    }
}
