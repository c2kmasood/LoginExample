/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package business;

/**
 *
 * @author Masood
 */
public class NoSuchProjectException extends Exception {

    public NoSuchProjectException(String msg) {
        super(msg);
    }

    public NoSuchProjectException() {
        super("project doesn't exist");
    }
    
}
