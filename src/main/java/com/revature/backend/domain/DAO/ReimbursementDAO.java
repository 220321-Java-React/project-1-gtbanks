package com.revature.backend.domain.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.revature.backend.domain.model.Reimbursement;

import com.revature.backend.util.ConnectionUtil;
import com.sun.org.apache.xerces.internal.util.Status;

import static com.revature.backend.util.ConnectionUtil.getConnection;

public class ReimbursementDAO implements ReimbursementDAOInterface {
private UserDAO userDAO = new UserDAO();


    @Override
    public List<Reimbursement> getAll(Integer userId)
            throws SQLException {
        if(userDAO.isManager(userId)) {
            try (Connection connection = getConnection()) {
                String sql = "select * from ers_reimbursement;";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
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
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, reimbursement.getReimb_amount());
            preparedStatement.setString(2, reimbursement.getReimb_submitted());
            preparedStatement.setInt(3, reimbursement.getReimb_author_id_fk());
            preparedStatement.setInt(4, reimbursement.getReimb_status_id_fk());
            preparedStatement.setInt(5, reimbursement.getReimb_type_id_fk());

            preparedStatement.executeUpdate();

        /*    if(resultSet.next()) {
                Reimbursement newReimbursement = new Reimbursement(
                        resultSet.getInt("reimb_id"),
                        resultSet.getInt("reimb_amount"),
                        resultSet.getString("reimb_submitted"),
                        resultSet.getInt("reimb_author_id_fk"),
                        resultSet.getInt("reimb_status_id_fk"),
                        resultSet.getInt("reimb_type_id_fk")

                );
               return newReimbursement;

            }
*/
        } catch (SQLException e) {
            System.out.println("Error selecting your request");
        }
        return null;
    }

    @Override
    public void update(int reimbursementId, Status updatedStatus) {

    }

}

/*
    int reimb_id, String reimb_type, String reimb_submitted,
        int reimb_author_id_fk, int reimb_status_id_fk, int reimb_type_id_fk

 */