package com.jing.currency;

import com.jing.currency.thread.MyThread;

import java.util.concurrent.*;

public class ThreadTest {

    public static void main(String[] args) {
        final String state = "5654";
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,8,
//                200, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>());

        ExecutorService executor = Executors.newFixedThreadPool(5);
        String str = "fdsf";
        for(int i=0;i<5;i++){
            Thread thread = new Thread(()->{
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
            executor.execute(thread);

        }
        executor.shutdown();
        FutureTask<Integer> future = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1;
            }
        });
    }

    public static int getInfo(int flag){
        return flag;
    }

}
