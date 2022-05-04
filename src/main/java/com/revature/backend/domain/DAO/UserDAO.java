package com.revature.backend.domain.DAO;

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
    //add new method
    @Override
    public boolean isManager(int userId) throws SQLException {
        try (Connection connection = getConnection()) {
            String sql = "select user_role_id_fk from ers_user where user_id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

//Ben updated code to fix menu loop

            //include required variables in ps
            preparedStatement.setInt(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();

            //first applied here will identify any rows in the resultSet
            if(resultSet.next()) {
                //if is used vs while because there is only one user for this login
                Integer userRoleId = resultSet.getInt("user_role_id_fk");
                if(userRoleId == 1) {
                    return true;
                }
                return false;
            }
            else {
                return false;

            }
            //Remember to close try before catch
        }
        catch (SQLException e) {
            System.out.println("Error selecting your request");
            throw e;
        }

    }
}
