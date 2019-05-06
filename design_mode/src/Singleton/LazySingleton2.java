package Singleton;

/**
 * @Author: huangjingyan
 * @Date: 2019/5/6 21:23
 * @Version 1.0
 */
public class LazySingleton2 {
    private static LazySingleton2 instance;

    private LazySingleton2(){};

    public static LazySingleton2 getInstance(){
        if(instance == null){
            instance = new LazySingleton2();
        }
        return instance;
    }
}
