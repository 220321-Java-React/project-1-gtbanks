package com.revature.backend.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Class manages db connection
public class ConnectionUtil {

    //connection method returns an object of type Connection, which can connecto to db
    public static Connection getConnection() throws SQLException {

        //For compatibility with other tech/frameworks, register this conn to PostgreSQL driver
        //ProstgreSQL is the Driver class for this connection
        try {
            Class.forName("org.postgresql.Driver"); //searching for the postgres driver/dependency
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Driver error");
        }
        String connectionString = "jdbc:postgresql://localhost:5432/postgres?currentSchema=p_one";
        //AWS connection stopped due to free tier chrg.
        // String connectionString = "jdbc:postgresql://projectone.crkzplgaa0b3.us-west-1.rds.amazonaws.com:5432/postgres?currentSchema=project_one";
                    String username = System.getenv("DB_USER");
                    String password = System.getenv("DB_PASS");

                    return DriverManager.getConnection(connectionString, username, password);
        }

    }



