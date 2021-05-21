package com.example.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * The class is responsible for creating a connection to the database
 */
public class SphinxConnectionCreator {

    /**
     * Сreates a connection to the database
     */
    public static Connection init() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:9306/?characterEncoding=Cp1251&maxAllowedPacket=1048576",
                "",
                "");
    }
}

