package strategy;

/**
 * @Author: huangjingyan
 * @Date: 2019/9/10 20:34
 * @Version 1.0
 */
public class OperateMultiply implements  Strategy {
    @Override
    public int operateNum(int a, int b) {
        return a*b;
    }
}
