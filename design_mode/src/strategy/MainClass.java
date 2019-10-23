package strategy;

/**
 * @Author: huangjingyan
 * @Date: 2019/9/10 20:38
 * @Version 1.0
 */
public class MainClass {
    public static void main(String[] args) {

        OperateMultiply multiply = new OperateMultiply();
        ExecuteContext context = new ExecuteContext(multiply);
        System.out.println(context.Operate(5,3));
        OperationAdd add = new OperationAdd();
        context = new ExecuteContext(add);
        System.out.println(context.Operate(4,3));
        OperationSubStract substract = new OperationSubStract();
        context = new ExecuteContext(substract);
        System.out.println(context.Operate(7,2));
    }
}
