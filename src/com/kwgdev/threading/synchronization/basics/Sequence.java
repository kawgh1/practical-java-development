package com.kwgdev.threading.synchronization.basics;

// helper class used to count thread operations
public class Sequence {

    private int value = 0;

    // This method is NOT THREAD SAFE - which means it doensn't work the way we expect it to
    public int getNext() {
        // not thread safe
//        value = value + 1;
//        return value;

        // thread safe using synchronized{} - means if a thread goes to sleep or stalls
        // while working inside this block,
        // Java won't let another thread start a new operation on this block until the first one finishes
        // this is called a Thread Lock
        synchronized (this) {
            value = value + 1;
            return value;
        }
    }

    // shorthand by defining method signature
    public synchronized int getNext2() {
        value++;
        return value;
    }
}
