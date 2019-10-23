package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: huangjingyan
 * @Date: 2019/10/23 22:32
 * @Version 1.0
 */
public class ProxyTest {

    static interface Subject{
        void sayHi();
        void sayHello();
    }

    static class SubjectImpl implements Subject{

        @Override
        public void sayHi() {
            System.out.println("hi");
        }

        @Override
        public void sayHello() {
            System.out.println("hello");
        }
    }


    public static class ProxySpeakHandler implements InvocationHandler{
        private Subject subject;

        public ProxySpeakHandler(Subject subject) {
            this.subject = subject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return method.invoke(subject,args);
        }
    }

    public static void main(String[] args) {
        Subject subject = new SubjectImpl();
        Subject proxy = (Subject)Proxy.newProxyInstance(subject.getClass().getClassLoader(),subject.getClass().getInterfaces(),new ProxySpeakHandler(subject));
        proxy.sayHello();
        proxy.sayHi();

    }


}
