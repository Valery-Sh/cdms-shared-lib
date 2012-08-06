package org.cdms.entities;

import java.io.Serializable;

/**
 *
 * @author V. Shyshkin
 */
public class PropertyFilter implements Serializable {
    private String fieldName;
    private String opName;
    private Object value;
    private boolean stringProperty;
    
    public PropertyFilter() {
        
    }
    public PropertyFilter(String fieldName, String opName,Object value) {
        this.fieldName = fieldName;
        this.opName = opName;
        this.value = value;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getOpName() {
        return opName;
    }

    public void setOpName(String opName) {
        this.opName = opName;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public boolean isStringProperty() {
        return stringProperty;
    }

    public void setStringProperty(boolean stringProperty) {
        this.stringProperty = stringProperty;
    }
    
}
