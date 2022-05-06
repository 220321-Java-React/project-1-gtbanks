package com.revature.backend.domain.dao;

import java.sql.SQLException;
import java.util.List;


import com.revature.backend.domain.model.Reimbursement;

public interface ReimbursementDAOInterface {

        //list abstract methods to include in DAO class
        //Method 1a: View all requests Mgr
        List<Reimbursement> getAll(Integer userId) throws SQLException; //did not need {}

        //Method 2: View all requests Staff

        List<Reimbursement> getAllOfMine(int authorId) throws SQLException;

        //Method: 3 view all requests by status: Mgr
        List<Reimbursement> getAllbyStatus() throws SQLException;

        //Method 4: Filter requests by staff: Staff
        List<Reimbursement> getMineByStatus() throws SQLException;

        //Method 5: create new request
        Reimbursement create(Reimbursement reimbursement);

        //Method 6: resolve request
        void updateStatus (int reimbursementId, int updatedStatus);

    }


