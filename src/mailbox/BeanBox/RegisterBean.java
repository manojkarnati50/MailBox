/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailbox.BeanBox;

/**
 *
 * @author manoj.karnati
 */
public class RegisterBean {
    
    private String FName;
    private String MName;
    private String LName;
    private String UID;
    private String Password1;
    private String password2;

    public RegisterBean() {
    }

    

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getMName() {
        return MName;
    }

    public void setMName(String MName) {
        this.MName = MName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getPassword1() {
        return Password1;
    }

    public void setPassword1(String Password1) {
        this.Password1 = Password1;
    }

    public String getPassword2() {
        return password2;
    }

    public RegisterBean(String FName, String MName, String LName, String UID, String Password1, String password2) {
        this.FName = FName;
        this.MName = MName;
        this.LName = LName;
        this.UID = UID;
        this.Password1 = Password1;
        this.password2 = password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    
    
    
}
