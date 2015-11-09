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
import mailbox.DataBox.RegisterUser;

/**
 *
 * @author manoj.karnati
 */
public class HomeLogic {
    Scanner User_Input = new Scanner(System.in);
    private String choice;
    
    public void HomePage() throws SQLException{
        
        System.out.println("\n\n\t\t\t\t\t-----Welcome to MailBox.com-----\t\t\t\t\t\n");
        System.out.println("Please choose an option below");
        System.out.println("(R) Register to Mailbox.com");
        System.out.println("(L) LogIn");
        System.out.println("(Press any other key) Exit Application");
        choice = User_Input.nextLine();
        UserChoice(choice);
    }
    public void UserChoice(String c) throws SQLException{
        if(c.toUpperCase().equals("R")){
            RegisterLogic r = new RegisterLogic();
            r.Register();
        }
        else if(c.toUpperCase().equals("L")){
            LoginLogic l = new LoginLogic();
            l.Login();
        }
        else{
            System.exit(0);
        }
    }
    
}
