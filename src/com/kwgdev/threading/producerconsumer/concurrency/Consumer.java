package com.kwgdev.threading.producerconsumer.concurrency;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    BlockingQueue<Integer> questionQueue;

    public Consumer(BlockingQueue<Integer> questionQueue) {
        this.questionQueue = questionQueue;

    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(2500); // delay to simulate answering question
                System.out.println("ANSWERED QUESTION:  " + questionQueue.take()); // take removes item from queue and returns it, like pop()

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
