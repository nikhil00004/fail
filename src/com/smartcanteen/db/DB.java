package com.smartcanteen.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    private static final String DB_HOST =
            System.getenv().getOrDefault(
                    "DB_HOST",
                    "localhost"
            );

    private static final String DB_PORT =
            System.getenv().getOrDefault(
                    "DB_PORT",
                    "3306"
            );

    private static final String DB_NAME =
            System.getenv().getOrDefault(
                    "DB_NAME",
                    "smart_canteen_db"
            );

    private static final String DB_USER =
            System.getenv().getOrDefault(
                    "DB_USER",
                    "root"
            );

    private static final String DB_PASSWORD =
            System.getenv().getOrDefault(
                    "DB_PASSWORD",
                    ""
            );

    public static final String DB_URL =
            "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME
            + "?sslMode=REQUIRED"
            + "&allowPublicKeyRetrieval=true"
            + "&serverTimezone=UTC";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(
                    "MySQL JDBC driver not found on classpath.", e);
        }
    }

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(
                DB_URL,
                DB_USER,
                DB_PASSWORD
        );
    }
}
