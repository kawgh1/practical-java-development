package com.kwgdev.lambdas.practical;

import java.util.Arrays;
import java.util.List;

public class App1 {

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

//        printCarsPriceRange(cars, 18000, 22000);
//        printCarByColor(cars, "Red");

        System.out.println("\nPrinting cars between 18000 and 22000...\n");
//        printCars(cars, new CarCondition() {
//            @Override
//            public boolean test(Car car) {
//                return car.getPrice() >= 18000 && car.getPrice() <=22000;
//            }
//        });

        // Same thing done with lambdas
        printCars(cars, (car) -> car.getPrice() >= 18000 && car.getPrice() <=22000);

        System.out.println("\nPrinting cars that are blue...\n");
//        printCars(cars, new CarCondition() {
//
//            @Override
//            public boolean test(Car car) {
//                return car.getColor().equals("Blue");
//            }
//        });

        // Same thing done with lambdas
        printCars(cars, (car) -> car.getColor().equals("Blue"));
    }
    // END MAIN


        // So often users want to see cars in a certain price range, all cars of a certain
        // model, year, color, mileage, # of owners, # of doors, 4WD, etc.

        // Rather than stub out all of these possible methods that the user can call,
        // is there a better way?

        // Yes -> lambdas

        // We create 1 method that takes in a user defined Car Condition
        // and test to see what cars, if any, meet that condition(s)

        public static void printCars(List<Car> cars, CarCondition condition) {
            for(Car car : cars) {
                if(condition.test(car)) {
                    car.printCar();
                }
            }
        }











    // print cars whose prices fall between low and high value
//    public static void printCarsPriceRange(List<Car> cars, int low, int high) {
//        for(Car car : cars) {
//            if(low <= car.getPrice() && car.getPrice() <= high) {
//                car.printCar();
//            }
//        }
//    }
//
//    public static void printCarByColor(List<Car> cars, String color) {
//        for(Car car : cars) {
//            if(car.getColor().equals(color)) {
//                car.printCar();
//            }
//        }
//    }
}

@FunctionalInterface
interface CarCondition {
    public boolean test(Car car);

}