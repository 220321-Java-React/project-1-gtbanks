package com.revature.backend.domain.dao;

import com.revature.backend.domain.model.User;

import java.sql.SQLException;

public interface UserDAOInterface {

    //We simply use "login" in this method because we are not returning anything
    User login(String username, String password) throws SQLException;
    //Method to ck for Manager status
    boolean isManager(int userId) throws SQLException;



}
