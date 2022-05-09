package com.revature.services;

import com.revature.backend.domain.dao.ReimbursementDAO;
import com.revature.backend.domain.dao.UserDAO;
import com.revature.backend.domain.model.Reimbursement;
import com.revature.backend.domain.model.User;
import com.revature.backend.dtos.UserLoginDTO;
import com.revature.backend.service.AuthService;
import com.revature.backend.service.ReimbursementService;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class TestClassPlaceholder {

    private AuthService authService = new AuthService();

    private UserDAO userDAO = new UserDAO();

    ReimbursementService reimbursementService = new ReimbursementService();

    //Use the @Test annotation
    @Test
    public void testValidLogin() throws SQLException {
        UserLoginDTO userLoginDTO = new UserLoginDTO();
        userLoginDTO.setUsername("elamb");
        userLoginDTO.setPassword("eric");
        User user = authService.userLogin(userLoginDTO);
              assertNotNull(user);
    }

    @Test
    public void testInvalidLoginCredentials() throws SQLException {
        UserLoginDTO userLoginDTO = new UserLoginDTO();
        userLoginDTO.setUsername("askme");
        userLoginDTO.setPassword("aaron");
        User user = authService.userLogin(userLoginDTO);
        assertNull(user);
    }

    @Test
    public void isNotAManager() throws SQLException {
        Integer isNotAManager = 20;
          assertFalse(userDAO.isManager(isNotAManager));
    }

    @Test
    public void isAManager() throws SQLException {
        Integer isAManager = 1;
        assertTrue(userDAO.isManager(isAManager));
    }

    @Test
    public void getAllStaffReimbursements() throws SQLException {
        int staffUserId = 3;
        List<Reimbursement> reimbursementList = reimbursementService.getAll(staffUserId);
        for(Reimbursement reimbursement: reimbursementList) {
            assertEquals(staffUserId, reimbursement.getReimb_author_id_fk() );
        }
    }

    @Test
    public void testCanUpdateStatus() {
        ReimbursementDAO reimburseentDAOTest = new ReimbursementDAO();
        // List<Reimbursement> reimbursementList = reimburseentDAOTest.updateStatus("")
    }
}



 /*       @Test
        //The test will not return anything so return type void
        //Make the name descriptive of what you want it to do

        void loginRequiresValidUsernameAndPassword() {

            String correctUsername = ;
            int correctPassword = Integer.


            }
        }
*/
