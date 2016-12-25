package newlandframework.netty.rpc.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * RPC服务器启动模块
 * Created by dy on 2016/12/24.
 */
public class RpcServerJdkNativeProtocolStarter {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("rpc-invoke-config-jdknative.xml");
    }
}
