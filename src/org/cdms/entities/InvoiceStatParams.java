
package org.cdms.entities;

import java.util.Date;

/**
 * Used by Statistics module to keep parameters to statistics request 
 * methods.
 * @author V. Shyshkin
 */
public class InvoiceStatParams {
    private Long id;
    private Date startDate;
    private Date endDate;
    
    public InvoiceStatParams() {
        
    }

    public InvoiceStatParams(Long id, Date startDate, Date endDate) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
}
