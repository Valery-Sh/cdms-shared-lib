package org.cdms.remoting.validation;


import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.cdms.remoting.exception.RemoteValidationException;

/**
 * The class is a wrapper around the class <code>javax.validation.Validator</code>.
 * It's {@link #validate(java.lang.Object } method invokes the corresponding
 * <code>validate()</code> of the <code>Validator</code> and throws an exception
 * of type {@link org.cdms.remoting.exception.RemoteValidationException } if 
 * an error found.
 * 
 * The class may be used on the client and server side.
 * 
 * @author V. Shyshkin
 */
public class ValidationHandler {


    protected Validator validator;
    /**
     * Sets the  <code>validator</code> property to
     * the the specified object of  type <code>Validator</code>. 
     * 
     * @param validator the value to be set
     */
    public void setValidator(Validator validator) {
        this.validator = validator;
    }
    /**
     * Validates the specified entity.
     * @param entity the object to be validated
     * @throws RemoteValidationException
     */
    public <T> void validate(T entity) {
        Set<ConstraintViolation<T>> errs = validator.validate(entity);
        if (errs.size() > 0 ) {
            RemoteValidationException rve = new RemoteValidationException("Validation error(s) found");
            for (ConstraintViolation<T> cv : errs) {
                //cv.getConstraintDescriptor().
                RemoteConstraintViolation rcv = new RemoteConstraintViolation(cv.getInvalidValue(), cv.getMessage(), cv.getMessageTemplate(), cv.getPropertyPath().toString());
                rcv.setAnnotationClassName(cv.getConstraintDescriptor().getAnnotation().annotationType().getName());
                rcv.getAttributes().putAll(cv.getConstraintDescriptor().getAttributes());
                rve.getViolations().add(rcv);
            }
            throw rve;
        }
    }
    
}
