package com.sai.notification.utility;

import java.util.concurrent.atomic.AtomicInteger;

import static com.sai.notification.utility.threadpool.atomicInteger;

public class runnable implements Runnable {

    //public AtomicInteger atomicInteger;

    @Override
    public void run(){
        atomicInteger.incrementAndGet();
    }
}
