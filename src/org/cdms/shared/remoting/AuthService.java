package org.cdms.shared.remoting;

/**
 * Defines authenticate functionality 
 * @author V. Shyshkin
 */
public interface AuthService {
    /**
     * Performs authentication for the given user name and password
     * @param name the name of the user to be authenticated
     * @param password the password of the user to be authenticated
     * @return 
     */
    UserInfo authenticate(String name, String password);
    
}
