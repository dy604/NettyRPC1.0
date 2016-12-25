package newlandframework.netty.rpc.servicebean;

/**
 * 计算器定义接口实现
 * Created by dy on 2016/12/24.
 */
public class CalculateImpl implements Calculate {

    //两数相加
    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
