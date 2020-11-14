package com.kwgdev.threading.producerconsumer.basics;

import java.util.ArrayList;
import java.util.List;

// Producer Consumer Design Pattern
// This basic example uses a simple ArrayList - a ArrayBlockingQueue is more appropriate and concurrent

public class Application {

    public static void main(String[] args) {

        // ArrayList is a shared data structure used by a Producer and Consumer thread
        List<Integer> questionList = new ArrayList<Integer>();

        Thread t1 = new Thread(new Producer(questionList));
        Thread t2 = new Thread(new Consumer(questionList));

        t1.start();
        t2.start();
    }
}
