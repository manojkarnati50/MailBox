/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailbox.LogicBox;


import java.net.SocketOptions;
import java.sql.SQLException;
import java.util.Scanner;
import mailbox.BeanBox.RegisterBean;
import mailbox.DataBox.RegisterUser;





/**
 *
 * @author manoj.karnati
 */
public class RegisterLogic {
    Scanner User_Input = new Scanner(System.in);
    RegisterBean bean = new RegisterBean();
    HomeLogic home = new HomeLogic();
    RegisterUser user = new RegisterUser();
    private Object User;
    
   public void Register() throws SQLException{
       
       System.out.println("\t\t\t\t\t-----User Registration Page-----\t\t\t\t\t\n");
       System.out.println("Enter First Name:");
       bean.setFName(User_Input.next());
       System.out.println("Enter Last Name:");
       bean.setLName(User_Input.next());
       System.out.println("Enter UserId:");
       bean.setUID(User_Input.next());
       System.out.println("Enter Password:");
       bean.setPassword1(User_Input.next());
       System.out.println("Re-enter Password:");
       bean.setPassword2(User_Input.next());
       
       /*
       This below while block checks whether the re-enter password matches with previously entered password.
       And loops runs until user enters matching passwords.
       */
       
       while(!bean.getPassword2().equals(bean.getPassword1())){
           System.out.println("Passwords dint match");
           System.out.println("Re-enter Password:");
           bean.setPassword2(User_Input.next());
       }
       boolean x = user.registerUser(bean.getUID(),bean.getFName(),bean.getLName(),bean.getPassword1());
       if(x==true){
           System.out.println("\t\t\t\t\t-----User exists!!, Please try with other user name.");
           this.Register();
       }
       else{
           System.out.println("\t\t\t\t\t-----Congratulations, your acccount has been succesfully created.");
       }
       /*
       The line below takes user back to homepage.
       */
       home.HomePage();
   }
    
}
