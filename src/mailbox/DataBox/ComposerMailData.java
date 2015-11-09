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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import mailbox.LogicBox.UserProfileLogic;

/**
 *
 * @author manoj.karnati
 */
public class ComposerMailData {
    boolean flag = false;
    Connection con = null;
    UserProfileLogic profile = new UserProfileLogic();
    Scanner user_Input = new Scanner(System.in);
    public boolean checkUser(String id) throws SQLException{
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mailbox", "root", "admin");
        } catch (SQLException ex) {
            Logger.getLogger(RegisterUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from mailbox.users where uid ='"+id+"';");
        if(rs.next())
            flag = true;
           
        else
            flag = false;
        
        return flag;
    }
    public void shootMail(String fid, String tid, String sub, String body, String time) throws SQLException, InterruptedException{
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mailbox", "root", "admin");
        } catch (SQLException ex) {
            Logger.getLogger(RegisterUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        Statement st = con.createStatement();
        st.execute("insert into mailbox.mails values('"+fid+"','"+tid+"','"+sub+
                "','"+body+"','"+time+"','no');");
        System.out.println("Mail has sent succesfully");
        System.out.println("please press any key to go back to main menu");
        user_Input.next();
        profile.UserProfile(fid);
    }
    public void displayMails(String id) throws SQLException{
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mailbox", "root", "admin");
        } catch (SQLException ex) {
            Logger.getLogger(RegisterUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        Statement st = con.createStatement();
        String query ="select u.lname, u.fname, m.subject, m.time, m.read from "
                +"mailbox.users u, mailbox.mails m where u.uid = m.from and m.to ='"+id+"';";
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            if(rs.getString(5).equalsIgnoreCase("no"))
            System.out.println("\t"+rs.getRow()+". "+rs.getString(1)+" "+rs.getString(2)+", "+rs.getString(3)+" (new) "+rs.getString(4));
            else
            System.out.println("\t"+rs.getRow()+". "+rs.getString(1)+" "+rs.getString(2)+", "+rs.getString(3)+" "+rs.getString(4));    
        }
        
    }
    public void sentMails(String uid) throws SQLException, InterruptedException{
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mailbox", "root", "admin");
        } catch (SQLException ex) {
            Logger.getLogger(RegisterUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        Statement st = con.createStatement();
        String query = "select u.lname, u.fname, m.subject, m.time, m.read from "
                +"mailbox.users u, mailbox.mails m where u.uid = m.to and m.from ='"+uid+"';";
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            System.out.println("\t"+rs.getRow()+". "+rs.getString(1)+" "+rs.getString(2)+", "+rs.getString(3)+" "+rs.getString(4));
              
        }
        System.out.println("please press any key to go back to main menu");
        user_Input.next();
        profile.UserProfile(uid);
    }
}
