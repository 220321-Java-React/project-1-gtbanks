package com.revature.backend.domain.DAO;

import com.revature.backend.domain.model.User;

import java.sql.SQLException;

public interface UserLoginDAOInterface {

    User login(String username, String password, int userRole) throws SQLException;


}
