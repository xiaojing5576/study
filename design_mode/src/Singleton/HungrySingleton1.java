package Singleton;

/**
 * @Author: huangjingyan
 * @Date: 2019/5/6 21:59
 * @Version 1.0
 */
public class HungrySingleton1 {
    private static HungrySingleton1 instance = null;
    static{
        instance = new HungrySingleton1();
    }
    private HungrySingleton1(){};
    public static HungrySingleton1 getInstance(){
        return instance;
    }
}
