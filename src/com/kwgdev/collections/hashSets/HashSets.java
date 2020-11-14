package com.kwgdev.collections.hashSets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class HashSets {

    // All Sets contain NO DUPLICATES

    public static void main(String[] args) {

        HashSet<Integer> values = new HashSet<Integer>();

        values.add(12);
        values.add(12);
        values.add(12);
        values.add(12);
        values.add(12);
        values.add(12);
        values.add(43);
        values.add(15);
        values.add(67);
        values.add(43);

        // even tho I added 12 six times and 43 twice, since its a set only one of each is added
        // theres also no specific order of insertion or retrieval

        for(Integer value : values) {
            System.out.println(value);
        }

        System.out.println("\n\n");

        // LinkedHashSets DO maintain order of insertion and retrieval
        LinkedHashSet<String> words = new LinkedHashSet<String>();

        words.add("zoo");
        words.add("Cats");
        words.add("bucket");
        words.add("dime");
        words.add("dime");
        words.add("dime");
        words.add("dime");
        words.add("funny");
        words.add("Australia");
        words.add("java!");

        for(String word : words) {
            System.out.println(word);
        }

        System.out.println("\n\n");


        // Hash Sets use object.hashCode() to determine uniqueness

        // If we don't @Override the equals() and hashCode() methods in the Animal class
        // it the HashSet will see them as two different objects
        // even though they have the same values
        HashSet<Animal> animals = new HashSet<Animal>();

        Animal animal1 = new Animal("Dog", 12);
        Animal animal2 = new Animal("Dog", 12);
        Animal animal3 = new Animal("Cat", 6);
        Animal animal4 = new Animal("Elephant", 19);

        animals.add(animal1);
        animals.add(animal2);
        animals.add(animal3);
        animals.add(animal4);

        System.out.println("Does animal1 equal animal2?    " + animal1.equals(animal2));

        for(Animal animal : animals){
            System.out.println(animal);
        }

        System.out.println("\n\n");


        /// List Collections can be transformed into each other

        HashSet<Employee> hashSet = new HashSet<Employee>();
        hashSet.add(new Employee("Mike", 3500, "Accounting"));
        hashSet.add(new Employee("Sam", 4500, "IT"));
        hashSet.add(new Employee("Angel", 2700, "Executive"));
        hashSet.add(new Employee("Rachel", 5500, "Staff"));
        hashSet.add(new Employee("Sarah", 4000, "QA"));

        // HashSets cant be sorted because only List<> types can be sorted
        // So to sort a HashSet have to turn it into a List

        // we pass the hashSet as the parameter for the new list
        ArrayList<Employee> myList = new ArrayList<Employee>(hashSet);

        // in our @Override compareTo() method in Employee.class, we sorted by salary

        Collections.sort(myList);

        System.out.println(myList.toString());



    }
}
