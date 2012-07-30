package org.cdms.remoting;

import org.cdms.entities.User;

/**
 *
 * @author V. Shyshkin
 */
public interface UserService {
    User findById(long userId);
    void insert(User user);
    void update(User user);
    void delete(long id);
    User authenticate(String userName, String password);
    
}
