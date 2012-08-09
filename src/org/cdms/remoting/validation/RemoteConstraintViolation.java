package org.cdms.remoting.validation;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author V. Shyshkin
 */
public class RemoteConstraintViolation implements Serializable{
    private Object invalidValue;
    private String constraintMessage;
    private String constraintMessageTemplate;    
    private String propertyPath;
    private String annotationClassName;
    private Map<String,Object> attributes;
    
    public RemoteConstraintViolation(Object invalidValue, String constraintMessage, String constraintMessageTemplate, String propertyPath) {
        this.invalidValue = invalidValue;
        this.constraintMessage = constraintMessage;
        this.constraintMessageTemplate = constraintMessageTemplate;
        this.propertyPath = propertyPath;
        attributes = new HashMap<String,Object>();
    }

    public String getAnnotationClassName() {
        return annotationClassName;
    }

    public void setAnnotationClassName(String annotationClassName) {
        this.annotationClassName = annotationClassName;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public Object getInvalidValue() {
        return invalidValue;
    }

    public void setInvalidValue(Object invalidValue) {
        this.invalidValue = invalidValue;
    }

    public String getConstraintMessage() {
        return constraintMessage;
    }

    public void setConstraintMessage(String constraintMessage) {
        this.constraintMessage = constraintMessage;
    }

    public String getConstraintMessageTemplate() {
        return constraintMessageTemplate;
    }

    public void setConstraintMessageTemplate(String constraintMessageTemplate) {
        this.constraintMessageTemplate = constraintMessageTemplate;
    }

    public String getPropertyPath() {
        return propertyPath;
    }

    public void setPropertyPath(String propertyPath) {
        this.propertyPath = propertyPath;
    }
    
    public String getMinAttribute() {
        String v = attributes == null || attributes.isEmpty() ? null : attributes.get("min").toString();
        return v;
    }
    public String getMaxAttribute() {
        String v = attributes == null || attributes.isEmpty() ? null : attributes.get("max").toString();
        return v;
    }
    public String getSizeExpression() {
        String e = null;
        if ( getMinAttribute() != null && getMaxAttribute() != null) {
            e = "[" + getMinAttribute() + "-" + getMaxAttribute() + "]";
        } else if ( getMinAttribute() != null ) {
            e = " >= " + getMinAttribute();
        } else if ( getMaxAttribute() != null ) {
            e = " <= " + getMaxAttribute();
        }
        return e;
    }

}
