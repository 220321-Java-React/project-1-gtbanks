package com.revature.backend.domain.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.revature.backend.domain.model.Reimbursement;

import com.revature.backend.util.ConnectionUtil;

import static com.revature.backend.util.ConnectionUtil.getConnection;

public class ReimbursementDAO implements ReimbursementDAOInterface {
//UserDAO will allow us to call the isManager method
private UserDAO userDAO = new UserDAO();

//This class will ck for user and Manager status
    @Override
    public List<Reimbursement> getAll(Integer userId)
            throws SQLException {
        //If the user isManager then connect to the db and retrieve ALL reimbs.
        if(userDAO.isManager(userId)) {
            try (Connection connection = getConnection()) {
                String sql = "select * from ers_reimbursement;";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
               // preparedStatement.setInt(1, userId); removed to debug postman seemed to work
               //but how did it work?
                ResultSet resultSet = preparedStatement.executeQuery();
                List<Reimbursement> reimbursementList = new ArrayList<>();
                while (resultSet.next()) {
                    Reimbursement reimbursement = new Reimbursement(
                            resultSet.getInt("reimb_id"),
                            resultSet.getInt("reimb_amount"),
                            resultSet.getString("reimb_submitted"),
                            resultSet.getInt("reimb_author_id_fk"),
                            resultSet.getInt("reimb_status_id_fk"),
                            resultSet.getInt("reimb_type_id_fk")
                    );
                    reimbursementList.add(reimbursement);
                }

                return reimbursementList;
            } catch (SQLException e) {
                System.out.println("Error selecting your request");
                return new ArrayList<>();
            }
            //If the user is not a Manager we only retrieve user's reimbursements, so
            //we specify this by filtering to a single id with the sql WHERE clause
        }else {

        try (Connection connection = getConnection()) {
            String sql = "select * from ers_reimbursement where reimb_author_id_fk = ? ;";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Reimbursement> reimbursementList = new ArrayList<>();
            while (resultSet.next()) {
                Reimbursement reimbursement = new Reimbursement(
                        resultSet.getInt("reimb_id"),
                        resultSet.getInt("reimb_amount"),
                        resultSet.getString("reimb_submitted"),
                        resultSet.getInt("reimb_author_id_fk"),
                        resultSet.getInt("reimb_status_id_fk"),
                        resultSet.getInt("reimb_type_id_fk")
                );
                reimbursementList.add(reimbursement);
            }

            return reimbursementList;
        } catch (SQLException e) {
            System.out.println("Error selecting your request");
            return new ArrayList<>();
        }
        }
    }

    @Override
    public List<Reimbursement> getAllOfMine(int authorId) throws SQLException {
        List<Reimbursement> reimbursementList = new ArrayList<>();

        try (Connection connection = ConnectionUtil.getConnection()) {

            String sql = "select * from reimbursement where reimb_author_id_fk;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, authorId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Reimbursement reimbursement = new Reimbursement(
                        resultSet.getInt("reimb_id"),
                        resultSet.getInt("reimb_amount"),
                        resultSet.getString("reimb_submitted"),
                        resultSet.getInt("reimb_author_id_fk"),
                        resultSet.getInt("reimb_status_id_fk"),
                        resultSet.getInt("reimb_type_id_fk")
                );
                reimbursementList.add(reimbursement);
            }

        } catch (SQLException e) {
            System.out.println("Error selecting your request");
        }

        return null;
    }

    @Override
    public List<Reimbursement> getAllbyStatus() throws SQLException {
        return null;

    }

    @Override
    public List<Reimbursement> getMineByStatus() throws SQLException {
        return null;
    }

    @Override
    public Reimbursement create(Reimbursement reimbursement) {
        try (Connection connection = ConnectionUtil.getConnection()) {

            String sql = "insert into ers_reimbursement values (Default, ?, ?, ?, ?, ?)";
            //"Default" may be case sensitive based on db sql
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, reimbursement.getReimb_amount());
            preparedStatement.setString(2, reimbursement.getReimb_submitted());
            preparedStatement.setInt(3, reimbursement.getReimb_author_id_fk());
            preparedStatement.setInt(4, reimbursement.getReimb_status_id_fk());
            preparedStatement.setInt(5, reimbursement.getReimb_type_id_fk());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error selecting your request");
        }
        return null;
    }

    @Override
    public List<Reimbursement> updateStatus(int reimbursementId, int updatedStatus) {

        try (Connection connection = ConnectionUtil.getConnection()) {

            String sql = "update ers_reimbursement set reimb_status_id_fk = ? where reimb_id = ?";
            //"Default" may be case sensitive based on db sql
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, updatedStatus);
            preparedStatement.setInt(2, reimbursementId);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error selecting your request");
        }
        return null;  //changed from @test update test implementation suggested by intelliJ
    }

}

/*
    int reimb_id, String reimb_type, String reimb_submitted,
        int reimb_author_id_fk, int reimb_status_id_fk, int reimb_type_id_fk

 */