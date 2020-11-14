package com.kwgdev.collections.lists;

import java.util.ArrayList;
import java.util.LinkedList;

public class Lists {

    public static void main(String[] args) {

        // Array List faster for retrieval, slower for manipulation
        ArrayList<String> words = new ArrayList<String>();
        words.add("hello");
        words.add("there");
        words.add("10");

        String items1 = words.get(2);

        System.out.println(items1);

        // Linked List faster for manipulation, slower for retrieval
        LinkedList<Integer> numbers = new LinkedList<Integer>();
        numbers.add(100);
        numbers.add(200);
        numbers.add(45);
        numbers.add(1000);

        for(int number : numbers){
            System.out.println(number);
        }

        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        Vehicle vehicle2 = new Vehicle("Toyota", "Camry", 12000, false);

        vehicles.add(new Vehicle("Honda", "Accord", 12000, false));
        vehicles.add(vehicle2);
        vehicles.add(new Vehicle("Jeep", "Wrangler", 25000, true));

        for(Vehicle car : vehicles) {
            System.out.println(car.toString());
        }
    }
}
