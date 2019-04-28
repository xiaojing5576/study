package com.jing.currency.thread;

public class MyThread implements Runnable {
    @Override
    public void run() {
        Thread.currentThread().getName();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
