package com.kwgdev.collections.hashSets;

public class Employee implements Comparable<Employee>{

    String name;
    int salary;
    String department;

    public Employee(String name, int salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    // for compareTo method of Comparable interface
    // must supply a case where 1 and -1 are returned
    @Override
    public int compareTo(Employee o) {

        // if less than, return -1
        if(this.salary < o.salary) {
            return -1;
            // if greater than return 1
        } else if(this.salary > o.salary) {
            return 1;
        }
        // otherwise (if equal) return 0
        return 0;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}' + "\n";
    }
}
