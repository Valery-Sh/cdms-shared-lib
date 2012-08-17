
package org.cdms.entities;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Transient;

/**
 *
 * @author V .Shyshkin
 */
public class InvoiceStatView implements Serializable {
    private String itemName;
    private Long itemCount;
    private transient BigDecimal totals;
    private String stringTotals;

    @Transient
    private transient PropertyChangeSupport changeSupport;

    
    public InvoiceStatView() {
        
    }

    public InvoiceStatView(String itemName, Long itemCount, BigDecimal totals,String stringPrice) {
        this.itemName = itemName;
        this.itemCount = itemCount;
        this.stringTotals = stringPrice;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        if ( changeSupport == null ) {
            changeSupport = new PropertyChangeSupport(this);
        }
        changeSupport.addPropertyChangeListener(listener);
    }
 
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        if ( changeSupport == null ) {
            return;
        }
        changeSupport.removePropertyChangeListener(listener);
    }    
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
        fire("price", oldValue, totals);
    }

    public String getStringTotals() {
        return stringTotals;
    }

    public void setStringTotals(String stringTotals) {
        this.stringTotals = stringTotals;
    }
    
}
