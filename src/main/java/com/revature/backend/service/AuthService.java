package com.revature.backend.service;


import com.revature.backend.domain.DAO.UserLoginDAO;
import com.revature.backend.domain.model.User;
import com.revature.backend.dtos.UserLoginDTO;

import java.sql.SQLException;

public class AuthService {
        //validate login creds. here by calling the UserLoginDAO
        //pull methods create ArrayList
        UserLoginDAO userLoginDAO = new UserLoginDAO();
        public User userLogin (UserLoginDTO userLoginDTO) throws SQLException {
        //Call the DAO method...use results in if() below
        //the DAO method would return whatever ges found in the db
        User user = userLoginDAO.login(userLoginDTO.getUsername(), userLoginDTO.getPassword());

        //since being called from controller it will return to controller
        return user;
    }





}
