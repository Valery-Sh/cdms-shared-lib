
package org.cdms.remoting;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The class is used on both the client and the server side and provides 
 * information about the authenticated user.
 * The content of an instance of the class is based on the content of the
 * {@link org.cdms.entities.User } class. Additional property named 
 * <code>ticket</code> may be used for security communication
 * between client and server and may contain an encoded password or 
 * http session identifier.
 * 
 * @author V. Shyshkin
 */
public class UserInfo implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private Object proxyFactory;
    
    private List<String> roles = new ArrayList<String>();
    

    private String ticket;
    /**
     * @return the value of the property with the name <code>ticked</code>.
     */
    public String getTicket() {
        return ticket;
    }
    /**
     * Sets the new value of the <code>ticket</code> to the specified value.
     * @param ticket the value to be set
     */
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
    /**
     * @return the value of the user identifier.
     */
    public Long getId() {
        return id;
    }
    /**
     * Sets the new value of the user entity identifier.
     * @param id the new value of the property
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @return the user's first name.
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Sets the new value of the user's first name to the specified value.
     * @param firstName the new first name to be set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * @return the user's last name.
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Sets the new value of the user's last name to the specified value.
     * @param lastName the new last name to be set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * @return the name that is used for authentication.
     */
    public String getUserName() {
        return userName;
    }
    /**
     * Sets the new value of the user's user name to the specified value.
     * @param userName the new user name to be set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    /**
     * @return the list of the permissions of the authenticated user.
     */
    public List<String> getRoles() {
        return roles;
    }
    /**
     * Sets the new list of permissions to the specified value.
     * @param roles the permissions to be set
     */
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
    /**
     * Checks, whether the authenticated user is in one of the specified 
     * roles (permissions).
     * @param role the array of roles 
     * @return 
     */
    public boolean inRole(String... role) {
        for ( String r : role ) {
            if ( getRoles().contains(r)) {
                return true;
            }
        }
        return false;
    }

    public Object getProxyFactory() {
        return proxyFactory;
    }

    public void setProxyFactory(Object proxyFactory) {
        this.proxyFactory = proxyFactory;
    }
    
    
}
