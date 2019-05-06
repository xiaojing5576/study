package Singleton;

/**
 * @Author: huangjingyan
 * @Date: 2019/5/6 21:28
 * @Version 1.0
 */

public class LazySingleton3 {
    private static LazySingleton3 instance;
    private LazySingleton3(){};

    public static synchronized LazySingleton3 getInsatnce(){
        if(instance == null){
            instance = new LazySingleton3();
        }
        return instance;

    }
}
