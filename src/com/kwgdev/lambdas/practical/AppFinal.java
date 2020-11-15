package com.kwgdev.lambdas.practical;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.Arrays;
import java.util.List;

// the full power of lambdas and how clean they can be

// This Final Application Class also makes use of the Java Functional Interface "Predicate"
// that implements a "test()" method for checking conditionals

// We can use the Predicate Interface to save us from having to write our own interface as in App1.java

public class AppFinal {

        public static void main(String[] args) {

            List<Car> cars = Arrays.asList(
                    new Car("Honda", "Accord", "Red", 22300),
                    new Car("Honda", "Civic", "Blue", 17700),
                    new Car("Toyota", "Land Cruiser", "White", 48500),
                    new Car("Toyota", "Carolla", "Black", 16200),
                    new Car("Toyota", "Camry", "Blue", 24000),
                    new Car("Nissan", "Sentra", "White", 17300),
                    new Car("Mitsubishi", "Lancer", "White", 20000),
                    new Car("Jeep", "Wrangler", "Red", 24500)
            );


            System.out.println("\nPrinting cars between 18000 and 22000...\n");

            printCars(cars, (car) -> car.getPrice() >= 18000 && car.getPrice() <=22000);

            System.out.println("\nPrinting cars that are blue...\n");

            printCars(cars, (car) -> car.getColor().equals("Blue"));
        }
        // END MAIN


        public static void printCars(List<Car> cars, Predicate<Car> predicate) {
            for(Car car : cars) {
                if(predicate.test(car)) {
                    car.printCar();
                }
            }
        }

}

