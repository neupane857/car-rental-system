package com.codewithRikesh;

import com.codewithRikesh.config.DatabaseConnection;

import java.sql.Connection;


public class Main {
    public static void main(String[] args) {

        Connection connection = DatabaseConnection.connect();
            if (connection != null) {
                // Connection successful, you can proceed with database operations
                System.out.println("You can now perform database operations.");
            } else {
                // Connection failed, handle accordingly
                System.out.println("Unable to perform database operations due to connection failure.");
            }
    }
}