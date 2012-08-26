package org.cdms.shared.remoting;

import org.cdms.shared.entities.Invoice;

/**
 * Defines  <code>insert,update, delete</code> and <code>find</code> functionality
 * for the <code>Invoice</code> class.
 * The class doesn't provide additional methods and serves as marker for 
 * the NetBeans RCP to distinguish between other classes that implement
 * {@link EntityService } .
 * 
 * @see org.cdms.entities.Invoice
 * @author V. Shyshkin
 */
public interface InvoiceService<E extends Invoice> extends EntityService<E>{

}
