package com.kwgdev.threading.producerconsumer.basics;

import java.util.List;

// Thread
// Producer produces questions, simulated as ints - question #1, question #2 - not actual questions
// Consumer consumes the questions by "answering" them, allow Producer to produce more questions to be answered
public class Consumer implements Runnable {

    List<Integer> questionList = null;

    public Consumer(List<Integer> questionList) {
        this.questionList = questionList;
    }

    // wait() and notify() can only be called inside a synchronized block - makes sense
    // wait() and notify() are primitive ways of inter-thread communication and should be avoided
    // use "concurrent utilities" instead that Java provides
    // Also an simple ArrayList is not ideal for a Producer-Consumer data structure

    public void answerQuestion() throws InterruptedException {

        synchronized (questionList) {
            while(questionList.isEmpty()) {
                System.out.println("No questions to answer ... waiting for producer to ask questions");
                questionList.wait();
            }
        }

        synchronized (questionList) {
            // longer sleep because it takes longer to answer questions then ask them
            Thread.sleep(5000);
            System.out.println("Question answered:  " + questionList.remove(0)); //FIFO list queue
            // notify() tells any Thread waiting on (questionList) that it's now available for work
            questionList.notify();
        }

    }


    @Override
    public void run() {
        // this will continue to run until the program is stopped
        while(true){
            try {
                answerQuestion();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }
}
