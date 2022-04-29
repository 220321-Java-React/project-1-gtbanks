package com.revature;

import io.javalin.Javalin;
import com.revature.backend.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;

//The following package names do not compile??
//import com.revature.ConnectionUtil;

public class Launcher {

    public static void main(String[] args) {

        //try catch tests if Connection from ConnectionUtil Class is successfull
        //Note: getConnection() will return a Connection Object if successful
            try(Connection connection = ConnectionUtil.getConnection()) {

            }catch (SQLException e) {//Connection failure triggers catch exception and print StackTrace
                System.out.println("Failed Connection");
                e.printStackTrace();
            }
        //Sending web HTTP reqs. to Java Server
        //Javalin is a tech used to take in HTTP reqs. from frontend and send back HTTP Resps.
        //HTTP Resps. can be anything from reqs data to status code received.

        //Instatiating an EmployeeController object to gain access to Javalin Handelers
        //designed to send reqs to the right controller


        //Create connection
        //Typical Javalin syntax to create a Javalin object
        Javalin app = Javalin.create(
                //the config lambda lets us specify certain configurations.
                config -> {
                    config.enableCorsForAllOrigins(); //allows us to process JS requests from
                }
        ).start(3000);
        //We ned to make some endpoint handlers, which will take in requests and send them where
        //need to go.they are like the traffic cop to your server thy direct it

        //handler ending in /employees
        //the app.get() method takes in a URL endpoint
        //  app.get("/employees", handler);

        //make a new class

    }
}




    	
    	//here we go again... have fun!!
    	
