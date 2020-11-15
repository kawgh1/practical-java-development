package com.kwgdev.lambdas.basics;

// LAMBDAS ARE BLOCKS OF CODE USES TO IMPLEMENT A METHOD DEFINED BY A FUNCTIONAL INTERFACE

public class App {
// Polymorphism
    public static void main(String[] args) {
        Human tom = new Human();
        walker(tom);

        Robot wale = new Robot();
        walker(wale);

        // Prior to Java 8 lambdas, this was as close as you could get to a pure class-independent function
        walker(new Walkable() {
            @Override
            public void walk() {
                System.out.println("Custom object walking...");

            }
        });

        //Java 8 lambda function - requires no class or object,
        // we just say hey run this code and whatever is inside the lambda runs
        walker( () -> System.out.println("Custom object walking..."));

        // assign lambda function to a variable - then can call variable anywhere to run that code
        // Very Important* - lambda expression MUST be of type functional interface
        ALambdaInterface aBlockOfCode = () -> {
            System.out.println("aBlockOfCode running...");
            System.out.println("lambda");
        };

        // change lambda type to Walkable which is also a functional interface
        Walkable aBlockOfCode2 = () -> {
            System.out.println("aBlockOfCode2 running...");
            System.out.println("lambda");
        };

        // now walker can call aBlockOfCode2
        walker(aBlockOfCode2);

        // new lambda of type Calculate interface, defined below
        Calculate sumVar = (a,b) -> a+b;
        System.out.println(sumVar.compute(4,6));

        // new lambda nonZeroDivide
        Calculate nonZeroDivider = (a,b) -> {
            if(a == 0) {
                return 0;
            }
            return a/b;
        };
        System.out.println(nonZeroDivider.compute(4,6)); // why does this return 0?
        System.out.println(nonZeroDivider.compute(10,5)); // and this return 2?


    }

    public static void walker(Walkable walkableEntity) {
        walkableEntity.walk();
    }
}

@FunctionalInterface
interface Calculate {
    public int compute(int arg1, int arg2);
}
