package com.revature.backend.domain.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.revature.backend.domain.model.Reimbursement;

import com.revature.backend.util.ConnectionUtil;

import static com.revature.backend.util.ConnectionUtil.getConnection;

public class ReimbursementDAO implements ReimbursementDAOInterface {

    @Override
    public List<Reimbursement> getAllOfMine() throws SQLException {
        return null;
    }

    @Override
    public List<Reimbursement> getAll(int reimb_id, String reimb_type, String reimb_submitted, int reimb_author_id_fk, int reimb_status_id_fk, int reimb_type_id_fk) throws SQLException {
        return null;
    }

    @Override
    public List<Reimbursement> getAll()
            throws SQLException {
        try (Connection connection = getConnection()) {
            String sql = "select * from ers_reimbursement;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Reimbursement> reimbursementList = new ArrayList<>();
            while (resultSet.next()) {
                Reimbursement reimbursement = new Reimbursement(
                        resultSet.getInt("reimb_id"),
                        resultSet.getString("reimb_type"),
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
                        resultSet.getString("reimb_type"),
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
        return null;
    }

    @Override
    public void update(int reimbursementId, Reimbursement updatedReimbursement) {

    }

}

/*
    int reimb_id, String reimb_type, String reimb_submitted,
        int reimb_author_id_fk, int reimb_status_id_fk, int reimb_type_id_fk

 */