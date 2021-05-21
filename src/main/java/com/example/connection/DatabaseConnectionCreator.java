package com.example.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionCreator {
    /**
     * Сreates a connection to the database
     */
    public static Connection init() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/addressbook",
                "root",
                "root");
    }
}

