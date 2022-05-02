package com.revature.backend.service;


import com.revature.backend.domain.DAO.UserLoginDAO;
import com.revature.backend.domain.model.User;
import com.revature.backend.dtos.UserLoginDTO;

import java.sql.SQLException;

public class AuthService {
        //validate login creds. here by calling the UserLoginDAO
        //pull methods create ArrayList

        //define UserLoginDAO which holds login method for db integration
        UserLoginDAO userLoginDAO = new UserLoginDAO();
        public User userLogin (UserLoginDTO userLoginDTO) throws SQLException {
        //method called from controller which has userloginDTO on HTTP request body
        //we use the UserLoginDTO as a parameter which contains username/password
        //SQL statements are in the DAO
        //we do not need if statement here

        //define userloginDAO
        //We are using params(username/password) in LoginDTO
        User user = userLoginDAO.login(userLoginDTO.getUsername(), userLoginDTO.getPassword(),
                                        userLoginDTO.getUserRole());

        //since being called from controller it will return to controller
        return user;
    }





}
