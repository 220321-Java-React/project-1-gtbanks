package com.revature.backend.service;

import com.revature.backend.domain.DAO.ReimbursementDAO;
import com.revature.backend.domain.model.Reimbursement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//The service layer contains additional bus logic needed to process requests/responses
//needed for login
public class ReimbursementService {

    ReimbursementDAO reimbursementDAO = new ReimbursementDAO();
    //call this method from Handler in Controller layer
    List arrayList = new ArrayList<>();
    public List<Reimbursement> getAll() throws SQLException {   //SQLException added by IntelliJ
        //get list of reimb from DAO
        List<Reimbursement> reimbursements = reimbursementDAO.getAll();

        //return that list of reimbursements
        return reimbursements;
        //
    }

}