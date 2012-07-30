package org.cdms.remoting;

/**
 *
 * @author V. Shyshkin
 */
public interface AuthService {
    UserInfo authenticate(String name, String password);
}
