package com.kwgdev.threading.synchronization.ThreadedInventoryManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InventoryManager {

    // this class represents two Threads accessing the same List Collection
    // and performing add/remove operations on the same data
    // practice using thread locks

    // Collections by default are not thread safe - so to use collections with threads
    // will need to perform some type of thread safety -> synchronized() or join(), etc.
    // Concurrent Collections or Vectors

//    List<Product> soldProductList = new ArrayList<Product>();
//    List<Product> purchasedProductList = new ArrayList<Product>();

    // CopyOnWriteArrayList is from Concurrent class

    /*A thread-safe variant of ArrayList in which all mutative operations (add, set, and so on)
    are implemented by making a fresh copy of the underlying array.

    This is ordinarily too costly, but may be more efficient than alternatives when traversal operations
    vastly outnumber mutations, and is useful when you cannot or don't want to synchronize traversals,
    yet need to preclude interference among concurrent threads.

    The "snapshot" style iterator method uses a reference to the state of the array at the point
    that the iterator was created.*/

    List<Product> soldProductList = new CopyOnWriteArrayList<Product>();
    List<Product> purchasedProductList = new CopyOnWriteArrayList<Product>();



    public void populateSoldProducts() {

        for(int i=0; i<100; i++) {
            Product prod = new Product(i, "test_product_" + i);
            soldProductList.add(prod);
            System.out.println("ADDED:  " + prod);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void displaySoldProducts() {
        for(Product product : soldProductList) {
            System.out.println("PRINTING THE SOLD: " + product);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
