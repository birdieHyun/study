package org.example.item7.executor;

import java.util.concurrent.CountDownLatch;

public class RunnableTask implements Runnable{

    private CountDownLatch countDownLatch;

    public RunnableTask(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            countDownLatch.countDown();
        }
        System.out.println(Thread.currentThread() + " world");
    }
}
