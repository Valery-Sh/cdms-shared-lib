package org.cdms.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 
 * @author V. Shyshkin
 */
@Entity 
@Table(name = "cdms_Customers") 
/*@NamedQueries({
    @NamedQuery(name = "CdmsCustomers.findAll", query = "SELECT c FROM CdmsCustomers c"),
    @NamedQuery(name = "CdmsCustomers.findById", query = "SELECT c FROM CdmsCustomers c WHERE c.id = :id"),
    @NamedQuery(name = "CdmsCustomers.findByVersion", query = "SELECT c FROM CdmsCustomers c WHERE c.version = :version"),
    @NamedQuery(name = "CdmsCustomers.findByFirstname", query = "SELECT c FROM CdmsCustomers c WHERE c.firstname = :firstname"),
    @NamedQuery(name = "CdmsCustomers.findByLastname", query = "SELECT c FROM CdmsCustomers c WHERE c.lastname = :lastname"),
    @NamedQuery(name = "CdmsCustomers.findByEmail", query = "SELECT c FROM CdmsCustomers c WHERE c.email = :email"),
    @NamedQuery(name = "CdmsCustomers.findByPhone", query = "SELECT c FROM CdmsCustomers c WHERE c.phone = :phone"),
    @NamedQuery(name = "CdmsCustomers.findByCreatedat", query = "SELECT c FROM CdmsCustomers c WHERE c.createdat = :createdat")})
*/
public class Customer implements Serializable {
    /**
     * For filter by example 
     */
    @Transient    
    private Date createdAtEnd;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CDMS_CUSTOMERS_SEQ")
    @SequenceGenerator(allocationSize=1,initialValue=10, name = "CDMS_CUSTOMERS_SEQ", sequenceName = "CDMS_CUSTOMERS_SEQ")    
    private Long id;
    @Version
    private Long version;

    @NotNull 
    @Size(min=1,max=16) 
    private String firstName;
    @NotNull 
    @Size(min=2,max=16) 
    private String lastName;
    @NotNull 
    @Size(min=3,max=64) 
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation    
    private String email;
    @NotNull 
    @Size(min=1,max=12) 
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    private String phone;
    
    @NotNull 
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdAt;
    
    @NotNull 
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="createdBy",referencedColumnName="id")
    private User createdBy;
    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getCreatedAtEnd() {
        return createdAtEnd;
    }

    public void setCreatedAtEnd(Date createdAtEnd) {
        this.createdAtEnd = createdAtEnd;
    }

}
