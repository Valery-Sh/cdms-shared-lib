package org.cdms.entities;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The entity that represents the table "CDMS_ITEMS" in the ORM mapping.
 * @author V. Shyshkin
 */
@Entity
@Table(name = "CDMS_ITEMS")
public class ProductItem implements Serializable{
    @Transient    
    private String stringPrice;
    
    /**
     * For filter by example 
     */
    @Transient    
    private String idFilter;
    
    @Transient    
    private Date createdAtEnd;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CDMS_ITEMS_SEQ")
    @SequenceGenerator(allocationSize=1,initialValue=10, name = "CDMS_ITEMS_SEQ", sequenceName = "CDMS_ITEMS_SEQ")    
    private Long id;
    
    @Version
    private Long version;
    @NotNull
    @Column(name = "PRICE")
    private BigDecimal price;
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "BARCODE")
    private String barcode;
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "ITEMNAME")
    private String itemName;
    @NotNull
    @Column(name = "CREATEDAT")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdAt;
    @JoinColumn(name = "CREATEDBY", referencedColumnName = "ID")
    @ManyToOne
    private User createdBy;

    public ProductItem() {
    }

    public ProductItem(Long id) {
        this.id = id;
        
    }

    public ProductItem(Long id, BigDecimal price, String barcode, String itemName, Date createdAt) {
        this.id = id;
        this.price = price;
        this.barcode = barcode;
        this.itemName = itemName;
        this.createdAt = createdAt;
    }
    @Transient
    private transient PropertyChangeSupport changeSupport;
    
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
        if ( changeSupport == null || ! changeSupport.hasListeners(propertyName)) {
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        BigDecimal oldValue = this.price;
        this.price = price;
        fire("price", oldValue, price);
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        String oldValue = this.barcode;
        this.barcode = barcode;
        fire("barcode", oldValue, barcode);
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        String oldValue = this.itemName;
        this.itemName = itemName;
        fire("itemName", oldValue, itemName);
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        Date oldValue = this.createdAt;
        this.createdAt = createdAt;
        fire("createdAt", oldValue, createdAt);
    }
    public Date getCreatedAtEnd() {
        return createdAtEnd;
    }

    public void setCreatedAtEnd(Date createdAtEnd) {
        Date oldValue = this.createdAtEnd;
        this.createdAtEnd = createdAtEnd;
        fire("createdAtEnd", oldValue, createdAtEnd);
    }
    public String getIdFilter() {
        return idFilter;
    }

    public void setIdFilter(String idFilter) {
        String oldValue = this.idFilter;
        this.idFilter = idFilter;
        fire("idFilter", oldValue, idFilter);
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        User oldValue = this.createdBy;
        this.createdBy = createdBy;
        fire("createdBy", oldValue, createdBy);
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
        if (!(object instanceof ProductItem)) {
            return false;
        }
        ProductItem other = (ProductItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.cdms.entities.ProductItem[ id=" + id + " ]";
    }

    public String getStringPrice() {
        return stringPrice;
    }

    public void setStringPrice(String stringPrice) {
        this.stringPrice = stringPrice;
    }
    
}
