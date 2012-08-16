
package org.cdms.entities;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

/**
 *
 * @author V. Shyshkin
 */
@Entity 
@Table(name = "cdms_InvoiceItems") 
public class InvoiceItem implements Serializable {
    /**
     * For filter by example 
     */
    @Transient    
    private String idFilter;
    

    @Transient
    private transient PropertyChangeSupport changeSupport;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CDMS_INVOICEITEMS_SEQ")
    @SequenceGenerator(allocationSize=1,initialValue=10, name = "CDMS_INVOICEITEMS_SEQ", sequenceName = "CDMS_INVOICEITEMS_SEQ")    
    private Long id;
    
    @Column(name = "VERSION")
    @Version
    private Long version;
    
    @NotNull
    @Column(name="ITEMCOUNT")
    private Integer itemCount;
    
    @Basic(optional = false)
    @NotNull
    @ManyToOne
    @JoinColumn (name="ITEMID", referencedColumnName = "ID") 
    private ProductItem productItem;
    
    @JoinColumn(name = "INVOICEID", referencedColumnName = "ID")
    @ManyToOne
    private Invoice invoice;

    public InvoiceItem() {
    }

    public InvoiceItem(Long id) {
        this.id = id;
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
        Long oldValue = this.id;
        this.id = id;
        fire("id", oldValue, id);
    }
    
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        Long oldValue = this.version;
        this.version = version;
        fire("version", oldValue, version);
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        Integer oldValue = this.itemCount;
        this.itemCount = itemCount;
        fire("itemCount", oldValue, itemCount);

    }


    public ProductItem getProductItem() {
        return productItem;
    }

    public void setProductItem(ProductItem productItem) {
        ProductItem oldValue = this.productItem;
        this.productItem = productItem;
        fire("productItem", oldValue, productItem);    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        Invoice oldValue = this.invoice;
        this.invoice = invoice;
        fire("invoice", oldValue, invoice);    
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

