package org.cdms.entities;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 *
 * @author V. Shyshkin
 */
@Entity 
@Table(name = "cdms_Invoices") 
public class Invoice implements Serializable {
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CDMS_INVOICES_SEQ")
    @SequenceGenerator(allocationSize=1,initialValue=10, name = "CDMS_INVOICES_SEQ", sequenceName = "CDMS_INVOICES_SEQ")    
    private Long id;
    @Column(name = "VERSION")
    private Long version;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdAt;    
    
    @JoinColumn(name = "CREATEDBY", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private User createdBy;
    
    @JoinColumn(name = "CUSTOMERID", referencedColumnName = "ID")
    @ManyToOne
    private Customer customer;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoice",fetch= FetchType.LAZY)
    private List<InvoiceItem> invoiceItems;

    public Invoice() {
    }

    public Invoice(Long id) {
        this.id = id;
    }

    public Invoice(Long id, Date createdAt) {
        this.id = id;
        this.createdAt = createdAt;
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
    

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        Date oldValue = this.createdAt;
        this.createdAt = createdAt;
        fire("createdAt", oldValue, createdAt);
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        User oldValue = this.createdBy;
        this.createdBy = createdBy;
        fire("createdBy", oldValue, createdBy);
    }

    public String getIdFilter() {
        return idFilter;
    }

    public void setIdFilter(String idFilter) {
        String oldValue = this.idFilter;
        this.idFilter = idFilter;
        fire("idFilter", oldValue, idFilter);
    }
    public Date getCreatedAtEnd() {
        return createdAtEnd;
    }

    public void setCreatedAtEnd(Date createdAtEnd) {
        Date oldValue = this.createdAtEnd;
        this.createdAtEnd = createdAtEnd;
        fire("createdAtEnd", oldValue, createdAtEnd);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        Customer oldValue = this.customer;
        this.customer = customer;
        fire("customer", oldValue, customer);
    }

    public List<InvoiceItem> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
        List<InvoiceItem> oldValue = this.invoiceItems;
        this.invoiceItems = invoiceItems;
        fire("invoiceItems", oldValue, invoiceItems);

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
        if (!(object instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.cdms.entities.Invoice[ id=" + id + " ]";
    }
    
}

