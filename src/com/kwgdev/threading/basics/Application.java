package com.kwgdev.threading.basics;

public class Application {

    public static void main(String[] args) {

        // thread 1
        Task taskRunner = new Task("Thread - A");
        System.out.println("Starting Thread 1:  ");
        taskRunner.start();



        // a thread can only be started once through to execution and cannot be restarted
        // this will generate an illegal thread state exception
//        taskRunner.start();

        // instead, instantiate a new thread
        // thread 2
        Task taskRunner2 = new Task("Thread - B");
        System.out.println("Starting Thread 2:  ");
        taskRunner2.start();


    }

}

// thread builder
class Task extends Thread {
    String name;

    public Task(String name) {
        this.name = name;
    }

    public void run(){
        Thread.currentThread().setName(this.name);
        for(int i=0; i < 10; i++){
            System.out.println("number: " + i + " - " + Thread.currentThread().getName());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
