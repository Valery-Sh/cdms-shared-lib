package org.cdms.shared.remoting;

import org.cdms.shared.entities.User;


/**
 *
 * @author V. Shyshkin
 */
public interface UserService {
    User findById(long userId);
    User findByUsername(String userName);
    void insert(User user);
    void update(User user);
    void delete(long id);
    
}
