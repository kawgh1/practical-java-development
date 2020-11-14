package com.kwgdev.threading.producerconsumer.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// USE THE CONCURRENT LIBRARY FOR ANY MULTI-THREADING, everything you need is in there

public class Application {

    public static void main(String[] args) {

        // accepts limit/capacity as parameter
        BlockingQueue<Integer> questionQueue = new ArrayBlockingQueue<Integer>(5);
        Thread t1 = new Thread(new Producer(questionQueue));
        Thread t2 = new Thread(new Consumer(questionQueue));

        t1.start();
        t2.start();

    }
}
