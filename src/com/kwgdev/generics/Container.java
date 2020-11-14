package com.kwgdev.generics;

// Some examples of defining classes with generic types and manipulating them

// first as of type Object, then as generic i1 and i2
public class Container<i1, i2> {

//    Object item1;
//    Object item2;
    i1 item1;
    i2 item2;

//    public Container(Object item1, Object item2) {
//        this.item1 = item1;
//        this.item2 = item2;
//    }
    public Container(i1 item1, i2 item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public void printItems(){
        System.out.println("Printing contents of Container:  ");
        System.out.println("Item1: " + item1);
        System.out.println("Item2: " + item2);
    }

//    public Object getItem1() {
//        return item1;
//    }
    public i1 getItem1() {
        return item1;
    }

//    public void setItem1(Object item1) {
//        this.item1 = item1;
//    }
    public void setItem1(i1 item1) {
        this.item1 = item1;
    }

//    public Object getItem2() {
//        return item2;
//    }
    public i2 getItem2() {
        return item2;
    }

//    public void setItem2(Object item2) {
//        this.item2 = item2;
//    }
    public void setItem2(i2 item2) {
        this.item2 = item2;
    }
}
