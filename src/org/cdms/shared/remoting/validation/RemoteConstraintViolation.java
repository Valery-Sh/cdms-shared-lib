package org.cdms.shared.remoting.validation;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * The instances of the class correspond to the objects of type 
 * <code>javax.validation.ConstraintViolation</code> which is part of the
 * Java Validation Framework (JSR 303).
 * 
 * @author V. Shyshkin
 */
public class RemoteConstraintViolation implements Serializable{
    
    public static final int SIZE = 0;
    public static final int MIN = 4;
    public static final int MAX = 8;
    public static final int DIGITS = 12;
    public static final int NOTNULL = 16;
    public static final int PATTERN = 20;
    
    public static final int OTHER = 100;
    
    
    
    
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

    public int getAnnotationCode() {
        int v = OTHER;
        if ( "javax.validation.constraints.Size".equals(getAnnotationClassName())) {
            v = SIZE;
        } else if ( "javax.validation.constraints.Min".equals(getAnnotationClassName())) {
            v = MIN;
        } else if ( "javax.validation.constraints.Max".equals(getAnnotationClassName())) {
            v = MAX;
        } else if ( "javax.validation.constraints.Digits".equals(getAnnotationClassName())) {
            v = DIGITS;
        } else if ( "javax.validation.constraints.NotNull".equals(getAnnotationClassName())) {
            v = NOTNULL;
        } else if ( "javax.validation.constraints.Pattern".equals(getAnnotationClassName())) {
            v = PATTERN;
        }
        return v;
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
        Object m = attributes == null || attributes.isEmpty() ? null : attributes.get("min");
        return m == null ? null : m.toString();
    }
    public String getMaxAttribute() {
        Object m = attributes == null || attributes.isEmpty() ? null : attributes.get("max");
        return m == null ? null : m.toString();
    }
    public String getPatternRegexpAttribute() {
        Object m = attributes == null || attributes.isEmpty() ? null : attributes.get("regexp");
        return m == null ? null : m.toString();
    }
    
/*    public String getDigitsAttribute() {
        Object m = attributes == null || attributes.isEmpty() ? null : attributes.get("digits");
        return m == null ? null : m.toString();
    }
    public String getNotNullAttribute() {
        Object m = attributes == null || attributes.isEmpty() ? null : attributes.get("notnull");
        return m == null ? null : m.toString();
    }
*/    
    
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
