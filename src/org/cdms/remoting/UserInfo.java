
package org.cdms.remoting;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author V. Shyshkin
 */
public class UserInfo implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    /**
     * For now contains password
     */
    private String ticket;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
    
    private List<String> roles = new ArrayList<String>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
    
    public boolean inRole(String... role) {
        for ( String r : role ) {
            if ( getRoles().contains(r)) {
                return true;
            }
        }
        return false;
    }
}
