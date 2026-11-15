package com.sai.notification.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Timer;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class threadpool {
    public static int counter = 0;
    public static AtomicInteger atomicInteger = new AtomicInteger(0);
    @Bean
    public ThreadPoolExecutor getExecutorService() {
        ThreadPoolExecutor tp = new ThreadPoolExecutor(
                5,
                10,
                100,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100)
        );

        return tp;
    }


    public static void main(String[] args) throws InterruptedException {
        /*Thread t = new Thread(() -> {
            System.out.println("Starting thread"+Thread.currentThread().getName());
            counter++;
        });*/

        ThreadPoolExecutor ex1 = new ThreadPoolExecutor(
                10,
                10,
                1,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(900)
        );

        /*Runnable r = new Runnable() {
            @Override
            public void run() {
                atomicInteger.incrementAndGet();
            }
        };*/

        for(int i=0;i<1000;i++){
            ex1.submit(new runnable());
        }

        ex1.shutdown();


        //t.start();
        Thread.sleep(2000);
        System.out.println("Starting thread"+Thread.currentThread().getName()+atomicInteger.get());
//        t.start();
    }
}
