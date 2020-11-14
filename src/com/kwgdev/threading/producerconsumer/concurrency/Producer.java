package com.kwgdev.threading.producerconsumer.concurrency;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    int questionNumber;

    BlockingQueue<Integer> questionQueue;

    public Producer(BlockingQueue<Integer> questionQueue) {
        this.questionQueue = questionQueue;

    }

    @Override
    public void run() {

        while(true){
            // if we had multiple Producer Threads we would want this questionNumber++
            // to be an all-or-nothing operation so it's thread safe -> synchronized
            // since we only have one, it is not necessary

            // also avoid using the synchronized(){} blocks more than necessary as it slows down performance quickly

            // now we are 100% thread safe, even with multiple Producers using a single synchronized block
            try {
                synchronized (this) {
                    int nextQuestion = questionNumber++;
                    System.out.println("Got new Question:  " + nextQuestion);
                    questionQueue.put(nextQuestion); // use put() not add(), add() is not thread safe
                }

            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }



    }
}
