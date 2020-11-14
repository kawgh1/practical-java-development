package com.kwgdev.threading.producerconsumer.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// USE THE CONCURRENT LIBRARY FOR ANY MULTI-THREADING, everything you need is in there

public class Application {

    public static void main(String[] args) {

        // accepts limit/capacity as parameter
        BlockingQueue<Integer> questionQueue = new ArrayBlockingQueue<Integer>(5);
        Thread t1 = new Thread(new Producer("Producer 1", questionQueue));
//        Thread t2 = new Thread(new Producer("Producer 2", questionQueue));
        Thread t3 = new Thread(new Consumer("Consumer 1", questionQueue));
//        Thread t4 = new Thread(new Consumer("Consumer 2", questionQueue));

        t1.start();
//        t2.start();
        t3.start();
//        t4.start();

    }
}
