package com.revature.backend.controller;

import com.google.gson.Gson;
import com.revature.backend.domain.model.Reimbursement;
import com.revature.backend.service.ReimbursementService;
import io.javalin.http.Handler;

import java.util.ArrayList;

//Controller layer is where HTTP requests get sent after Javalin direcs them
//Here, we parse any JSON into Java objects and vice versa
//OR we send data that came from the webpage to the service layer then sends to the DAO
public class ReimbursementController {

    ReimbursementService reimbursementService = new ReimbursementService();
    //this Handler will get the HTTP GET request for all reimbursements and send back reimb from db
    public Handler getAllHandler = (ctx) -> {

            //We need an ArrayList of Employee objects (we get from the service layer
            ArrayList<Reimbursement> reimbursements = (ArrayList<Reimbursement>) reimbursementService.getAll();
            //create a GSON object to convert java object to JSON (we can only transfer JSON (JSON universally understoond transfer lang
           Gson gson = new Gson();
           //Use the JSON .toJson() method to turn our Java into JSON
           String JSONReimbursements = gson.toJson(reimbursements);
        //Give a HTTP response containing JSON string back to the webpage//or origin
            ctx.result(JSONReimbursements); //.results sends a response of data back
            ctx.status(200); //.status() sets the HTTP status code. 200 =OK
    };



}
