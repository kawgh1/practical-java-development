package com.kwgdev.generics;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Application {

    public static void main(String[] args) {

        // Since Container is of type <i1,i2> generic any datatype can be passed in
        // but for Java to use it, the type must be declared at instantiation

        // Otherwise it will treat every data type the same - as Object

        Container<Integer, String> container = new Container<>(12, "Hello");
        // Because we used the second <>, Java knows to look at <Integer, String> and not
        // the class type of <i1, i2> - Compile Time Type Safety
        
        // just to show Container class is generic
        Container<Double, Boolean> container2 = new Container<>(12.7, true);

        int val1 = container.getItem1();
        String val2 = container.getItem2();

        Set<String> mySet1 = new HashSet<>();
        mySet1.add("first");
        mySet1.add("second");
        mySet1.add("whatever");

        Set<String> mySet2 = new HashSet<>();
        mySet1.add("first");
        mySet1.add("second");
        mySet1.add("computer");

        // if we don't define the Set <type> here, Java will treat them all as objects
        Set<String> resultSet = union2(mySet1, mySet2);

        // Iterator is interface implemented by Collections -> basically a for loop
        // Iterator<type> should always be declared, to avoid casting and type mismatch
        Iterator<String> itr = resultSet.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

        // without defining the types of these two Sets, any type could be passed in
        // and the result could contain Strings, Integers, etc.
        // which creates a lot of problems for any other class or method that uses this method
        public static Set union1(Set set1, Set set2){

            // Sets do not store duplicate values
            Set result = new HashSet(set1);
            result.addAll(set2);
            return result;

        }

        // So to convert this non-generic method into a generic method
        // 1. define type of the parameters <E>
        // 2. If the method takes in a datatype of <E>, it better return a type of <E> also
        // 3. We need to define what "E" is in our method, so JAVA and other users KNOW it's a generic method
        // (not as "String" or "Integer", but as "E")
        //      We define it *before* the return type, between "static" and "Set"
        // 4. Define the generic type within the method body


        public static <E> Set <E> union2(Set <E> set1, Set <E> set2) {

            // Sets do not store duplicate values
            Set<E> result = new HashSet<E>(set1);
            result.addAll(set2);
            return result;
        }


}
