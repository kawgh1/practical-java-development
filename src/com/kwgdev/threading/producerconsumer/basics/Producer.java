package com.kwgdev.threading.producerconsumer.basics;

import java.util.List;

// Thread
// Producer produces questions, simulated as ints - question #1, question #2 - not actual questions
// Consumer consumes the questions by "answering" them, allow Producer to produce more questions to be answered
public class Producer implements Runnable {

    List<Integer> questionList = null;
    final int LIMIT = 5;
    private int questionNumber;

    public Producer(List<Integer> questionList) {
        this.questionList = questionList;
    }

    // wait() and notify() can only be called inside a synchronized block - makes sense
    // wait() and notify() are primitive ways of inter-thread communication and should be avoided
    // use "concurrent utilities" instead that Java provides
    // Also an simple ArrayList is not ideal for a Producer-Consumer data structure

    public void readQuestion(int questionNumber) throws InterruptedException {

        synchronized (questionList) {
            while(questionList.size() == LIMIT) { // limit of only 5 questions at a time
                System.out.println("Questions have piled up ... wait for answers!");
                questionList.wait();
            }
        }

        synchronized (questionList) {
            System.out.println("New Question: " + questionNumber);
            questionList.add(questionNumber);
            Thread.sleep(500);
            // notify() tells any Thread waiting on (questionList) that it's now available for work
            questionList.notify();
        }

    }


    @Override
    public void run() {
        // this will continue to run until the program is stopped
        while(true){
            try {
                readQuestion(questionNumber++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }
}
