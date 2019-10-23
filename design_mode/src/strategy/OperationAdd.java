package strategy;

/**
 * @Author: huangjingyan
 * @Date: 2019/9/10 20:28
 * @Version 1.0
 */
public class OperationAdd implements Strategy{


    @Override
    public int operateNum(int a, int b) {

        return a+b;
    }
}
