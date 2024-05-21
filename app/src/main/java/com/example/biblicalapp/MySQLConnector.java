package com.example.biblicalapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQLConnector {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/proverbs";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private Connection connection;

    public void connect() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle connection errors
        }
    }

    public PreparedStatement prepareStatement(String query) throws SQLException {
        if (connection != null) {
            return connection.prepareStatement(query);
        } else {
            throw new SQLException("Connection is not established.");
        }
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle closing connection error
            }
        }
    }
}