package com.codewithRikesh.config;

import java.sql.Connection;
import java.sql.SQLException;

@FunctionalInterface
public interface DbConnector {
    Connection connection(String url, String username, String password) throws SQLException;
}
