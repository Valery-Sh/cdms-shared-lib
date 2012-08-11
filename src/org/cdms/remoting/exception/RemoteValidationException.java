package org.cdms.remoting.exception;

import java.util.ArrayList;
import java.util.List;
import org.cdms.remoting.validation.RemoteConstraintViolation;

/**
 *
 * @author V. Shyshkin
 */
public class RemoteValidationException extends RuntimeException {
    //private Object invalidValue;
    //private String constraintMessage;
    //private String constraintMessageTemplate;    
    //private String propertyPath;
    
    private List<RemoteConstraintViolation> violations;
    
    public RemoteValidationException(String message) {
        super(message);
        violations = new ArrayList<RemoteConstraintViolation>();
    }
    public RemoteValidationException(String message,Object invalidValue,String constraintMessage,
            String constraintMessageTemplate, String propertyPath) {
        this(message);
//        this.invalidValue = invalidValue;
//        this.constraintMessage = constraintMessage;
//        this.constraintMessageTemplate = constraintMessageTemplate;
//        this.propertyPath = propertyPath;
    }

    public List<RemoteConstraintViolation> getViolations() {
        return violations;
    }

    
}
