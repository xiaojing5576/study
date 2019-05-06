package Singleton;

/**
 * @Author: huangjingyan
 * @Date: 2019/5/6 21:31
 * @Version 1.0
 */
public class LazySingleton4 {

    /**
     * 双重校验锁的实现方式中，静态成员变量singleton必须通过volatile来修饰，保证其初始化不被重排，否则可能被引用到一个未初始化完成的对象。
     */
    private volatile static LazySingleton4 instance;
    private LazySingleton4(){}
    private LazySingleton4 getInstance(){
        if (instance == null){
            synchronized (LazySingleton4.class){
                if(instance == null){
                    instance = new LazySingleton4();
                }
            }
        }
        return instance;
    }
}
