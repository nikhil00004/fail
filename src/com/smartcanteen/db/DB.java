package com.smartcanteen.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Opens a JDBC connection to MySQL using plain java.sql (no JPA/Hibernate).
 * Each handler opens a connection with DB.connect(), uses it in a
 * try-with-resources block, and it closes automatically. For a small
 * college project this is simpler and easier to explain than a
 * connection pool.
 *
 * Update DB_URL / DB_USER / DB_PASSWORD to match your own MySQL setup.
 */
public class DB {

    public static final String DB_URL =
            "jdbc:mysql://localhost:3306/smart_canteen_db?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "Nikhil@0608";

    static {
        try {
            // Loads the MySQL JDBC driver class (mysql-connector-j jar
            // must be on the classpath - see README for how to add it).
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(
                    "MySQL JDBC driver not found on classpath. " +
                    "Download mysql-connector-j and put the jar in the lib/ folder. See README.md.", e);
        }
    }

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
