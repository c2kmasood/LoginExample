/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Masood
 */
@Entity
@NamedQueries({
    @NamedQuery(name = LogUser.FIND_BY_LOGIN, query = "select user from LogUser user where user.name=:name and user.passwd=:passwd"),
    @NamedQuery(name = LogUser.FIND_ALL, query = "select user from LogUser user")
})
public class LogUser implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String passwd;

    @OneToMany(mappedBy="userName", orphanRemoval=true, cascade=CascadeType.ALL)
    private List<UserFunctionItem> userFunctions; 
    
    public static final String FIND_BY_LOGIN = "LogUser.findByLogin";
    public static final String FIND_ALL = "LogUser.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    
    public LogUser(){        
    }
    
    public LogUser(String name, String passwd){
        this.name = name;
        this.passwd = passwd;
    }

    public void setUserFunction(UserFunctionItem ufItem){
        if (userFunctions != null){
          userFunctions.add(ufItem);
        }        
    }
    
    public String getUserFunction() {
//        try {
            return userFunctions.get(0).getFunctionName();
//        } catch (Exception e) {
//            return "User don't have funktion";
//        }
        
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogUser)) {
            return false;
        }
        LogUser other = (LogUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.loginsolution.model.LogUser[ id=" + id + " ]";
    }
    
}
