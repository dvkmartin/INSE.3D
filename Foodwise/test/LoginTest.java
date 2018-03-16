/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rohit
 */
public class LoginTest {
    
    @Test
    public void testInvalidLogin() {
        System.out.println("invalid login test!");
        String username = "dummy";
        String password = "moredummy";
        Login instance = new Login();
        int expResult = -1;
        int result = instance.login(username, password);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testSuccessLogin() {
        System.out.println("success login test!");
        String username = "new@user.com";
        String password = "pass";
        Login instance = new Login();
        int expResult = 22;
        int result = instance.login(username, password);
        assertEquals(expResult, result);
        
    }

}
