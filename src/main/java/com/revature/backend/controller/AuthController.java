package com.revature.backend.controller;

import com.google.gson.Gson;

import com.revature.backend.domain.model.User;
import com.revature.backend.dtos.UserLoginDTO;
import com.revature.backend.service.AuthService;
import io.javalin.http.Handler;

import javax.servlet.http.HttpSession;


public class AuthController {
    //We need an AuthService object to use it's method
    AuthService authService = new AuthService();

    //empty HttpSession object will be filled on login success
    static HttpSession session;

    //loginHandler to handle login req() which go to app.post("/login", xxx)
    //import Handler.io.Javalin
    public Handler loginHandler = (ctx) -> {
        //post requests have incoming data, which we access with ctx.body/body of request/user data
        //Http reqs. handled via ctx.body();
        String body = ctx.body();

        //create new GSON object for Java <-> JSON conversions
        Gson gson = new Gson();

        //turn JSON String (now converted to Java) directly into a LoginDTO object
        //remember, from Json() is the method that takes JSON and turns it into some Java object
        UserLoginDTO userLoginDTO = gson.fromJson(body, UserLoginDTO.class);

        //control flow to determine what happens in the event of successful/unsuccessful login

        User user = authService.userLogin(userLoginDTO);
        if (user != null) {

            //IF successful login create a user session so they can access the appl functionalities
            session = ctx.req.getSession(true);

            //return successful status code
            ctx.status(202); //accepted

            //get our user object as JSON
            //here, use.toJson() to take in result of login success which is User object
            //String userJSON = gson.toJson(authService.ulog(loginDTO.getUsername(), loginDTO.getPassword()));
            //Send back our UserLogin object
            ctx.result(gson.toJson(user));

        } else {
            ctx.status(401); //unauthorized
            System.out.println("Failed Login");
        }
    };
}

