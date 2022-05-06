package com.revature.services.domain.dao;

import org.junit.Test;
import org.junit.jupiter.api.function.Executable;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.revature.backend.domain.dao.ReimbursementDAO;
import com.revature.backend.domain.dao.UserDAO;
import com.revature.backend.dtos.UserLoginDTO;
import com.revature.backend.domain.model.User;

public class UserDAOTest {

    UserDAO userDAOTest = new UserDAO();
    ReimbursementDAO reimbDAOTest = new ReimbursementDAO();
    User userTest = new User();

    //Use the @Test annotation
    @Test
    public void testValidLoginCredentials() throws SQLException {
        assertEquals(true, userDAOTest.login("sbriggs", "sheri"));
    
    }
    
    @Test
    public void testInvalidLoginCredentials() throws SQLException {
  //      assertFalse(userDAOTest.login("sggirbs", "irehs"));

    }

    @Test
    public void isNotAManager() {
//        assertFalse(userTest.isManager()
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