package com.codewithRikesh.config;

import com.codewithRikesh.exception.DatabaseException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    //private static final String URL = "jdbc:mysql://localhost:3306/CarRentalDB";
    //private static final String USERNAME = "root";
    //private static final String PASSWORD = "password";


    public static Connection connect(){

        String URL = requireEnv("DB_URL");
        String USERNAME = requireEnv("DB_USERNAME");
        String PASSWORD = requireEnv("DB_PASSWORD");
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Database connected successfully!");
            return connection;
        } catch (SQLException e) {
            throw new DatabaseException("Failed to connect to the database", e);
        }
    }

    private static String requireEnv(String key) {
        String value = System.getenv(key);

        if (value == null || value.isBlank()) {
            System.out.println("Missing required environment variable" + key);
            throw new IllegalStateException("Missing required environment variable: " + key);
        }
        return value;
    }
}
