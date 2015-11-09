/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailbox.LogicBox;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import mailbox.DataBox.ComposerMailData;

/**
 *
 * @author manoj.karnati
 */
public class ComposeMailLogic {
    
    Scanner User_Input = new Scanner(System.in);
    String ToID;
    
    public void writeMail(String fromid) throws SQLException, InterruptedException{
        ComposerMailData check = new ComposerMailData();
        System.out.println("From: "+fromid);
        System.out.print("To: ");
        ToID = User_Input.nextLine();
        boolean flag = check.checkUser(ToID);
        if(flag==false){
            System.out.println("User doesnt exists");
            writeMail(fromid);
        }
        else{
            System.out.print("Sub: ");
            String Subject = User_Input.nextLine();
            System.out.print("Body: ");
            String Body = User_Input.nextLine();
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MMMM d, y");
            String time = sdf.format(date);
            check.shootMail(fromid, ToID, Subject, Body, time);
        }
        
        
    }
}
