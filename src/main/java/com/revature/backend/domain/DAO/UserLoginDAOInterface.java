package com.revature.backend.domain.DAO;

import com.revature.backend.domain.model.User;

import java.sql.SQLException;

public interface UserLoginDAOInterface {

    //We simply use "login" in this method because we are not returning anything
    User login(String username, String password) throws SQLException;


}
