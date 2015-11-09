/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailbox;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import mailbox.LogicBox.HomeLogic;
import mailbox.LogicBox.RegisterLogic;

/**
 *
 * @author manoj.karnati
 */
public class MailBox {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mailbox", "root", "admin");
        Statement st = con.createStatement();
        HomeLogic home = new HomeLogic();
        home.HomePage();
        
        
    }
    
}
