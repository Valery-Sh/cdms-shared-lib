package org.cdms.shared.remoting;

import org.cdms.shared.entities.InvoiceItem;

/**
 * Defines  <code>insert,update, delete</code> and <code>find</code> functionality
 * for the <code>InvoiceItem</code> class.
 * The class doesn't provide additional methods and serves as marker for 
 * the NetBeans RCP to distinguish between other classes that implement
 * {@link EntityService } .
 * 
 * @see org.cdms.entities.InvoiceItem
 * @author V. Shyshkin
 */
public interface InvoiceItemService<E extends InvoiceItem> extends EntityService<E>{
    
}
