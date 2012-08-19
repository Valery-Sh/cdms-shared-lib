
package org.cdms.entities;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Transient;

/**
 * Represents a single row of the statistics results.
 * It is not an <i>entity</i> and it is a bean that may be displayed
 * in a <code>JTable</code> or bound to any appropriate <code>JComponent</code>.
 * @author V .Shyshkin
 */
public class InvoiceStatView implements Serializable {
    private String itemName;
    private Long itemCount;
    private transient BigDecimal totals;
    private String stringTotals;

    @Transient
    private transient PropertyChangeSupport changeSupport;

    /**
     * Creates a new instance of the class.
     */
    public InvoiceStatView() {
        
    }
    /**
     * Creates a new instance with the specified parameters.
     * @param itemName the item name as specified by the 
     *      {@link org.cdms.entities.ProductItem} class
     * @param itemCount the total number of items
     * @param totals 
     * @param stringPrice 
     */
    public InvoiceStatView(String itemName, Long itemCount, BigDecimal totals,String stringPrice) {
        this.itemName = itemName;
        this.itemCount = itemCount;
        this.stringTotals = stringPrice;
    }
    /**
     * Used for binding.
     * @param listener 
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        if ( changeSupport == null ) {
            changeSupport = new PropertyChangeSupport(this);
        }
        changeSupport.addPropertyChangeListener(listener);
    }
    /**
     * Used for binding.
     * @param listener 
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        if ( changeSupport == null ) {
            return;
        }
        changeSupport.removePropertyChangeListener(listener);
    }    
    /**
     * A convenient method used to fire <code>PropertyChangeEvent</code>.
     * @param propertyName
     * @param oldValue
     * @param newValue 
     */
    protected void fire(String propertyName,Object oldValue, Object newValue) {
        if ( changeSupport == null ) {
            return;
        }
        changeSupport.firePropertyChange(propertyName, oldValue, newValue);

    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        String oldValue = this.itemName;
        this.itemName = itemName;
        fire("itemName", oldValue, itemName);

    }

    public Long getItemCount() {
        return itemCount;
    }

    public void setItemCount(Long itemCount) {
        Long oldValue = this.itemCount;
        this.itemCount = itemCount;
        fire("itemCount", oldValue, itemCount);
    }

    public BigDecimal getTotals() {
        return totals;
    }

    public void setTotals(BigDecimal totals) {
        BigDecimal oldValue = this.totals;
        this.totals = totals;
        fire("totals", oldValue, totals);
    }

    public String getStringTotals() {
        return stringTotals;
    }

    public void setStringTotals(String stringTotals) {
        this.stringTotals = stringTotals;
    }
    
}
