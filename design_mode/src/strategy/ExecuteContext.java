package strategy;

/**
 * @Author: huangjingyan
 * @Date: 2019/9/10 20:35
 * @Version 1.0
 */
public class ExecuteContext {

    private Strategy strategy;

    public ExecuteContext(Strategy strategy){
        this.strategy = strategy;
    }

    public int Operate(int a,int b){
        return  strategy.operateNum(a,b);
    }
}
