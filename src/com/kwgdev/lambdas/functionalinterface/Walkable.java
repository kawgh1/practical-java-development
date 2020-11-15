package com.kwgdev.lambdas.functionalinterface;

@FunctionalInterface
public interface Walkable {
// this too is a functional interface as long as it has only one abstract method
    // if we add another method, it ceases to be a functional interface and can no longer
    // be used for lambdas
    public void walk();
}
