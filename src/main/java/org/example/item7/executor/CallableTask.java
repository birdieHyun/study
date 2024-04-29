package org.example.item7.executor;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<String> {

    @Override
    public String call() throws Exception {

        Thread.sleep(2000L);
        return Thread.currentThread() + " world";
    }
}
