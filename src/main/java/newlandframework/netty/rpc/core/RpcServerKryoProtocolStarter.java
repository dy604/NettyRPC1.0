package newlandframework.netty.rpc.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * RPC服务器启动模块
 * Created by dy on 2016/12/24.
 */
public class RpcServerKryoProtocolStarter {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("newlandframework/netty/rpc/config/rpc-invoke-config-kryo.xml");
    }
}
