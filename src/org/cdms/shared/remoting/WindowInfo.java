package org.cdms.shared.remoting;

import java.util.ArrayList;
import java.util.List;

/**
 * A top component creates an instance of this class and adds to 
 * it's <code>lookup</code>.
 * @author V. Shyshkin
 */
public class WindowInfo {
    private List<String> roles;
    private UserInfo userInfo;
    private OperationHandler handler;
    
    public WindowInfo(OperationHandler handler) {
        this.handler = handler;
        roles = new ArrayList<String>();
    }

    public List<String> getRoles() {
        return roles;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
        if ( handler != null ) {
            handler.process(this);
        }
    }
    
    public interface OperationHandler {
        void process(WindowInfo windowInfo);
    }
}
