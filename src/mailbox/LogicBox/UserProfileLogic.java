/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailbox.LogicBox;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import mailbox.BeanBox.RegisterBean;
import mailbox.DataBox.RegisterUser;
import mailbox.DataBox.ComposerMailData;

/**
 *
 * @author manoj.karnati
 */
public class UserProfileLogic {
    RegisterBean bean = new RegisterBean();
    Scanner User_Input = new Scanner(System.in);
    HomeLogic home = new HomeLogic();
    ComposeMailLogic compose = new ComposeMailLogic();
    
    String Choice;
    String fromID;
    public void UserProfile(String uid) throws SQLException, InterruptedException{
        ComposerMailData data = new ComposerMailData();
        fromID = uid;
        String FName=null;
        String LName=null;
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mailbox", "root", "admin");
        } catch (SQLException ex) {
            Logger.getLogger(RegisterUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("select * from mailbox.users where uid ='"+uid+"';");
    while(rs.next()){
        FName=rs.getString(2);
        LName=rs.getString(3);
    }
        System.out.println("\nwelcome, "+FName+" "+LName+"\n");
        data.displayMails(uid);
        System.out.println("(n)Next Page");
        System.out.println("(p)Previous Page");
        System.out.println("(v)View Mails");
        System.out.println("(w)Write mail");
        System.out.println("(s)Sent Mails");
        System.out.println("(x)Logout");
        Choice = User_Input.next();

        UserChoice(Choice);
        
    }
    public void UserChoice(String c) throws SQLException, InterruptedException{
        if(c.toUpperCase().equals("W")){
            compose.writeMail(fromID);
        }
        else if(c.toUpperCase().equals("S")){
            ComposerMailData data = new ComposerMailData();
            data.sentMails(fromID);
        }
        else if(c.toUpperCase().equals("X")){
             home.HomePage();
        }
    }

    
}
