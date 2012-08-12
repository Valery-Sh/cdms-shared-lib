package org.cdms.remoting;

import org.cdms.entities.Invoice;

/**
 *
 * @author V. Shyshkin
 */
public interface InvoiceService {

    Invoice findById(long userId);
    //List<Invoice> findByExample(Invoice sample, long firstRecordMaxId,int pageSize);    
    QueryPage<Invoice> findByExample(QueryPage<Invoice> queryPage );    
    Invoice insert(Invoice customer);
    Invoice update(Invoice customer);
    Invoice delete(long id);
    
}
