
package org.cdms.entities;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 *
 * @author V. Shyshkin
 */
public class InvoiceItem implements Serializable {
    /**
     * For filter by example 
     */
    @Transient    
    private String idFilter;
    
    @Transient    
    private Date createdAtEnd;

    @Transient
    private transient PropertyChangeSupport changeSupport;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CDMS_INVOICEITEMS_SEQ")
    @SequenceGenerator(allocationSize=1,initialValue=10, name = "CDMS_INVOICEITEMS_SEQ", sequenceName = "CDMS_INVOICEITEMS_SEQ")    
    private Long id;
    
    @Column(name = "VERSION")
    private Long version;
    
    @NotNull
    private Integer itemCount;
    @Basic(optional = false)
    
    @NotNull
    private Long itemId;
    @JoinColumn(name = "INVOICEID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Invoice invoice;

    public InvoiceItem() {
    }

    public InvoiceItem(Long id) {
        this.id = id;
    }

    public InvoiceItem(Long id, Integer itemCount, Long itemId) {
        this.id = id;
        this.itemCount = itemCount;
        this.itemId = itemId;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemcount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public Long getItemid() {
        return itemId;
    }

    public void setItemid(Long itemId) {
        this.itemId = itemId;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
    public String getIdFilter() {
        return idFilter;
    }

    public void setIdFilter(String idFilter) {
        String oldValue = this.idFilter;
        this.idFilter = idFilter;
        fire("idFilter", oldValue, idFilter);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvoiceItem)) {
            return false;
        }
        InvoiceItem other = (InvoiceItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.cdms.entities.InvoiceItem[ id=" + id + " ]";
    }
    
}

