package com.revature.backend.controller;


import com.google.gson.Gson;

import com.revature.backend.dtos.UserLoginDTO;
import com.revature.backend.service.AuthService;
import io.javalin.http.Handler;

import javax.servlet.http.HttpSession;


public class AuthController {

    AuthService authService = new AuthService();

    //empty HttpSession object will be filled on login success
    static HttpSession session;

    //loginHandler to handle login req() which go to app.post("/login", xxx)
    //import Handler.io.Javalin
    public Handler loginHandler = (ctx) -> {

        //Http reqs. handeled via ctx.body();
        String body = ctx.body();

        //create new GSON object for Java <-> JSON conversions
        Gson gson = new Gson();

        //turn JSON String directly into a LoginDTO object
        //remember, from Json() is the method that takes JSON and turns it into some Java object
        UserLoginDTO loginDTO = gson.fromJson(body, UserLoginDTO.class);

        //control flow to determine what happens in the event of successful/unsuccessful login
        if(authService.login(loginDTO.getUsername(), loginDTO.getPassword()) ! = null) {

            //IF successful login create a user session so they can access the appl functionalities
            session = ctx.req.getSession(true);

            //return successful status code
            ctx.status(202); //accepted

            //get our employee object as JSON
            //here, use.toJson() to take in result of success login which is User object
            String userJSON = gson.toJson(authService.login(loginDTO.getUsername(), loginDTO.getPassword()));

            ctx.result(userJSON);

        }else {
                ctx.status(401); //unauthorized
                System.out.println("Failed Login");
         }
    }
}

