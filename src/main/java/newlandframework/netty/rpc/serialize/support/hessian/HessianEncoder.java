package newlandframework.netty.rpc.serialize.support.hessian;

import newlandframework.netty.rpc.serialize.support.MessageCodecUtil;
import newlandframework.netty.rpc.serialize.support.MessageEncoder;

/**
 * Hessian编码类
 * Created by dy on 2016/12/24.
 */
public class HessianEncoder extends MessageEncoder {

    public HessianEncoder(MessageCodecUtil util) {
        super(util);
    }
}
