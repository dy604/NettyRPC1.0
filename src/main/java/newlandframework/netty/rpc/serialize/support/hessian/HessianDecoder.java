package newlandframework.netty.rpc.serialize.support.hessian;

import newlandframework.netty.rpc.serialize.support.MessageCodecUtil;
import newlandframework.netty.rpc.serialize.support.MessageDecoder;

/**
 * Hessian解码器
 * Created by dy on 2016/12/24.
 */
public class HessianDecoder extends MessageDecoder {

    public HessianDecoder(MessageCodecUtil util) {
        super(util);
    }
}
