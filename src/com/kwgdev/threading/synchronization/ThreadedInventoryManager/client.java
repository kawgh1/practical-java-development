package com.kwgdev.threading.synchronization.ThreadedInventoryManager;

public class client {


    public static void main(String[] args) throws InterruptedException {
        InventoryManager manager = new InventoryManager();

        Thread inventoryTask = new Thread(new Runnable() {
            @Override
            public void run() {
                manager.populateSoldProducts();
            }
        });

        Thread displayTask = new Thread(new Runnable() {
            @Override
            public void run() {
                manager.displaySoldProducts();
            }
        });

        inventoryTask.start();
//        inventoryTask.join(); //join means basically don't run the next line until inventoryTask is complete
        inventoryTask.sleep(500);
        displayTask.start();
    }
}
