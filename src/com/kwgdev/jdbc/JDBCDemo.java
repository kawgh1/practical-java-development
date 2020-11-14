package com.kwgdev.jdbc;

import java.sql.*;

public class JDBCDemo {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://127.0.0.1:3306/employees_database";

        // Establish Connection object
        Connection conn = DriverManager.getConnection(url, "root", "password");

        // Create a statement object to send to the database
        Statement statement = conn.createStatement();

        // Execute statement object
        ResultSet resultSet = statement.executeQuery("select * from employees_tbl");

        int salaryTotal = 0;
        while(resultSet.next()) {
            // multiple Database operations

            // print all the employee names in database name column
            System.out.println(resultSet.getString("name"));

            // print total employee compensation
            salaryTotal = salaryTotal + resultSet.getInt("salary");
        }
        System.out.println("Total compensation of all employees:  " + salaryTotal);
    }
}
