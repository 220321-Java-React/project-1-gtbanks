package com.revature;

import io.javalin.Javalin;

import java.sql.Connection;
import java.sql.SQLException;

//The following package names do not compile??
//import com.revature.ConnectionUtil;

public class Launcher {

    private static Connection ConnectionUtil;

    public static void main(String[] args) {

       /* try(Connection conn = ConnectionUtil.getConnection()) {
            System.out.println("CONNECTED to ERS AWS )");
        }   catch(SQLException e) {//if connection fails, catch exception and print to StackTrace
                System.out.println("Connection Error");
                e.printStackTrace();
*/
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
    	
