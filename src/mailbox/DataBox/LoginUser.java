/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailbox.DataBox;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manoj.karnati
 */
public class LoginUser {
    public  boolean checkUser(String uid, String pass) throws SQLException{
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mailbox", "root", "admin");
        } catch (SQLException ex) {
            Logger.getLogger(RegisterUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("select * from mailbox.users where uid ='"+uid+"' and password ='"+pass+"';");
        if(rs.next()){
            return true;
        }
        else{
            return false;
        }
    }
}
