package com.revature;

import com.revature.backend.controller.AuthController;
import com.revature.backend.controller.ReimbursementController;
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
                System.out.println("CONNECTED TO ERS");

            }catch (SQLException e) {//Connection failure triggers catch exception and print StackTrace
                System.out.println("Oop!, Failed Connection");
                e.printStackTrace();
            }
        //Webpage needs to send HTTP requests to Java server
        //Javalin is a technology used to take in HTTP requests from FE and send back HTTP responses
        //HTTP Responses can range from requested data to status code: "data received" msg.

        //Instantiating an ReimbursementController object to access it's Handlers
        ReimbursementController reimbursementController = new ReimbursementController();

        AuthController authController = new AuthController();

        //Javalin syntax to create Javalin object
        Javalin app = Javalin.create(
                //the config lambda lets us specify certain configurations.
                config -> {
                    config.enableCorsForAllOrigins(); //overrides default...allows us to process JS requests from anywhere (overriding security protocol)
                }
        //starts Javalin application on port 3000
        ).start(3000);
        //We need to make some endpoint handlers, which will take in requests and send them where
        //they need to go.they are like the traffic cop to your server they direct traffic to specific appl locations

        //Endpoint handlers ending in reimbursement take in GET req - will return all reimbursements
        //the app.get() method takes in a URL endpoint and a place in the server to send the request
        app.get("/reimbursements", reimbursementController.getAllHandler);
        //handler ending in /login that takes in POST requests validates user login
        //the app.post() method takes in a URL endpoint, and a place in the server (Controller) to send the request

        app.post("/login", authController.loginHandler);
        app.post("/reimbursements", reimbursementController.createReimbursementHandler);

    }
}




    	
    	//here we go again... have fun!!
    	
