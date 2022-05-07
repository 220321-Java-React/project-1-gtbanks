package com.revature.backend.domain.dao;

import com.revature.backend.domain.model.User;

import java.sql.*;
import java.util.ArrayList;

import static com.revature.backend.util.ConnectionUtil.getConnection;

public class UserDAO implements UserDAOInterface {  //renamed from userlogindao
    @Override
    public User login(String username, String password) throws SQLException {

        try (Connection connection = getConnection()) {
            String sql = "select * from ers_user where username = ? and password = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //include required variables in ps
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            //Use an array list where the data type are String
            ArrayList<String> userLoginList = new ArrayList<String>();
            //first applied here will identify any rows in the resultSet
            //The list of values
            if(resultSet.next()) {
            //if is used vs while because there is only one user for this login
            //returning the whole user allows for some options in rendering user info on web page
                User user = new User(resultSet.getInt("user_id"),
                                    resultSet.getString("username"),
                                    resultSet.getString("password"),
                                    resultSet.getString("f_name"),
                                    resultSet.getString("l_name"),
                                    resultSet.getString("email"),
                                    resultSet.getInt("user_role_id_fk")
                        );
                //ck to make sure return user and else statements work threw an error fixed via IntelliJ
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
    //add new method to ck for Manager status where role = 1
    @Override
    public boolean isManager(int userId) throws SQLException {
        try (Connection connection = getConnection()) {
            //The user will enter userId and db will ck if user is Manager
            String sql = "select user_role_id_fk from ers_user where user_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //include required variable in ps mentioned in sql statement
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            //first applied here will identify any rows in the resultSet
            if(resultSet.next()) {
                //if the result set is true evaluate nested if(userRoleId), if false go to else{}
                Integer userRoleId = resultSet.getInt("user_role_id_fk");
                //Is manager returns a boolean we use an if() because only seeking one object
                //If statement checks to see if the userId entered is a manager
                if(userRoleId == 1) {
                    return true;
                }
                return false;
            }
            //else does not compile w/out return false; above
            else {
                return false;//if false user is not a Manager
            }
            //Remember to close try before catch
        }
        catch (SQLException e) {
            System.out.println("Error selecting your request");
            throw e;
        }
    }
}
