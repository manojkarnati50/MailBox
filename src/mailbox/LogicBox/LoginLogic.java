/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailbox.LogicBox;

import mailbox.DataBox.LoginUser;
import java.sql.SQLException;
import java.util.Scanner;
import mailbox.BeanBox.RegisterBean;

/**
 *
 * @author manoj.karnati
 */
public class LoginLogic {
    Scanner User_Input = new Scanner(System.in);
    RegisterBean registerBean = new RegisterBean();
    UserProfileLogic user = new UserProfileLogic();
    LoginUser loggedin = new LoginUser();
    HomeLogic home = new HomeLogic();
    
    public void Login() throws SQLException, InterruptedException{
        System.out.println("Please enter your User Id:");
        registerBean.setUID(User_Input.next());
        System.out.println("Please enter your password:");
        registerBean.setPassword1(User_Input.next());
        boolean flag = loggedin.checkUser(registerBean.getUID(), registerBean.getPassword1());
        if(flag==true){
            user.UserProfile(registerBean.getUID());  
        }
        else{
            System.out.println("Invalid userid or password! please try again.");
            home.HomePage();
        }
        
        
        
        
    }
    
}
