package org.cdms.remoting.validation;


import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

/**
 *
 * @author V. Shyshkin
 */
public class ValidationHandler {

    //@Autowired
    protected Validator validator;

    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    public <T> void validate(T entity) {
        Set<ConstraintViolation<T>> errs = validator.validate(entity);
        if (errs.size() > 0 ) {
            RemoteValidationException rve = new RemoteValidationException("Validation error(s) found");
            for (ConstraintViolation<T> cv : errs) {
                //cv.getConstraintDescriptor().
                RemoteConstraintViolation rcv = new RemoteConstraintViolation(cv.getInvalidValue(), cv.getMessage(), cv.getMessageTemplate(), cv.getPropertyPath().toString());
                rcv.setAnnotationClassName(cv.getConstraintDescriptor().getAnnotation().annotationType().getName());
                rve.getViolations().add(rcv);
            }
            throw rve;

            //throw new IllegalArgumentException("HAS VALIDATION ERRORS");
        }
    }
}
