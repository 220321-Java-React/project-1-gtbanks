package com.revature.backend.domain.DAO;

import com.revature.backend.domain.model.User;

import java.sql.*;
import java.util.ArrayList;

import static com.revature.backend.util.ConnectionUtil.getConnection;

public class UserLoginDAO implements UserLoginDAOInterface{
    @Override
    public User login(String username, String password, int userRole) throws SQLException {
        try (Connection connection = getConnection()) {
            String sql = "select * from ers_user where username = ? and password = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

//Ben updated code to fix menu loop

            //include required variables in ps
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            //Use an array list where the data type are String
            ArrayList<String> userLoginList = new ArrayList<String>();
            //first applied here will identify any rows in the resultSet
            if(resultSet.next()) {
            //if is used vs while because there is only one user for this login
                User user = new User(resultSet.getInt("user_id"),
                                    resultSet.getString("username"),
                                    resultSet.getString("password"),
                                    resultSet.getString("f_name"),
                                    resultSet.getString("l_name"),
                                    resultSet.getString("email"),
                                    resultSet.getInt("user_role_id_fk")
                        );
                return user;
            }
            else {
                return null;

            }
        //Remember to close try before catch
        }
           catch (SQLException e) {
                System.out.println("Error selecting your request");
                throw e;
            }
    }
}
