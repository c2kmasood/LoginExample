/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package business;

import model.LogUser;
import model.UserFunctionItem;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author Masood
 */
@Stateless
public class UserService {

    @PersistenceContext
    private EntityManager em;
    
    public Boolean createUser(String newUsername, String newUserpwd, String newUserfunction){
        try {
        LogUser nUser = new LogUser(newUsername, newUserpwd);
        em.persist(nUser);
        UserFunctionItem nUserfunction = new UserFunctionItem(newUserfunction);
        em.persist(nUserfunction);
        nUser.setUserFunction(nUserfunction);    
        }
        catch (Exception e) {
            return false;
        }
        
        return true;
    }
    
    public Boolean updateUser(LogUser entity){
        try {
            em.merge(entity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public List<LogUser> findAll() {
               List<LogUser> myUserList = em.createNamedQuery(LogUser.FIND_ALL,LogUser.class).getResultList();
               return myUserList;
    }
    
    public LogUser checkUser(String name, String passwd) throws NoSuchProjectException{
        List<LogUser> resultList = em.createNamedQuery(LogUser.FIND_BY_LOGIN, LogUser.class)
                .setParameter("name", name)
                .setParameter("passwd", passwd)
                .getResultList();
//        if (resultList != null && resultList.size() > 1) {
//            throw new IllegalStateException("User <" + name + "> was found more than once.");
//        }
        if (resultList != null && resultList.size() >= 1) {
            return resultList.get(0);
        }
        throw new NoSuchProjectException("User <" + name + "> doesn't exist.");
    }
    
    
}
