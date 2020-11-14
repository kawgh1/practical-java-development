package com.kwgdev.threading.producerconsumer.concurrency;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    String name;
    BlockingQueue<Integer> questionQueue;


    public Consumer(String name, BlockingQueue<Integer> questionQueue ) {
        this.name = name;
        this.questionQueue = questionQueue;

    }

    @Override
    public void run() {
        Thread.currentThread().setName(this.name);
        while(true) {
            try {
                // Thread safe
                // synchornized() for multiple Consumers, keeps them from answering the same question at same time
                synchronized (this) {
                    Thread.sleep(6000); // delay to simulate answering question
                    System.out.println("QUESTION ANSWERED BY " +
                            Thread.currentThread().getName() +":   " +
                            questionQueue.take()); // take removes item from queue and returns it, like pop()
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
