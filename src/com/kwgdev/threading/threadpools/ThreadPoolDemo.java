package com.kwgdev.threading.threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {

        // newFixedThreadPool takes number of threads as parameter
        // we don't tell it what threads do what, we just tell it how many threads
        // and it handles the threading, start, stop, waiting, whatever - we don't care
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable processor1 = new MessageProcessor(1);
        executor.execute(processor1);

        Runnable processor2 = new MessageProcessor(2);
        executor.execute(processor2);

        Runnable processor3 = new MessageProcessor(3);
        executor.execute(processor3);

        Runnable processor4 = new MessageProcessor(4);
        executor.execute(processor4);

        executor.shutdown(); // rejects any new tasks from being submitted and gracefully shuts down

        System.out.println("Submitted all tasks..."); // this still prints first while executor working

        // more code can run while threadpool executing
        // . . .
        // ...

        while(!executor.isTerminated()) {
            // empty loop runs until executor shuts down
        }

        // other timer method
        executor.awaitTermination(10, TimeUnit.SECONDS); // options for minutes, hours, days, etc.

        System.out.println("Completed all tasks...");


    }
}
