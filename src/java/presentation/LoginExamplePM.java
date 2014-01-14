/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentation;

import business.UserService;
import business.NoSuchProjectException;
import model.LogUser;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Masood
 */
@Named
@SessionScoped
public class LoginExamplePM implements Serializable {

    @EJB
    private UserService uservice;

    
    private String userName;
    private String userPasswd;
    private String userFunction;

    private String loggedUser;
    private String loggedUserFunction;

    public String getLoggedUserFunction() {
        return loggedUserFunction;
    }

    public void setLoggedUserFunction(String loggedUserFunction) {
        this.loggedUserFunction = loggedUserFunction;
    }
    
    public String getUserFunction() {
        return userFunction;
    }

    public void setUserFunction(String userFunction) {
        this.userFunction = userFunction;
    }

    public String getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(String loggedUser) {
        this.loggedUser = loggedUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPasswd() {
        return userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }
        
    public String createUser(){ 
//        AppUser newUser = new AppUser(this.userName, this.userPasswd);
//        UserFunctionItem newUFunction = new UserFunctionItem(this.userFunction);
        uservice.createUser(userName, userPasswd, userFunction);
       
        this.userFunction = "";
        
        return userLogin();
        
    }
    
    public String userLogin(){
        try {
            LogUser retVal = uservice.checkUser(this.userName, this.userPasswd);
            this.loggedUser = this.userName;
            this.loggedUserFunction = retVal.getUserFunction();
            this.userName = "";
            this.userPasswd = "";
            
            return "displayUsers";
        } catch (NoSuchProjectException e) {
            return "errorLogin";
        }
    }
        
    public List<LogUser> getUsers(){
        return uservice.findAll();
    }
    
}
