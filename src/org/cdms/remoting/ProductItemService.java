package org.cdms.remoting;

import org.cdms.entities.ProductItem;

/**
 * Defines  <code>insert,update, delete</code> and <code>find</code> functionality
 * for the <code>ProductItem</code> class.
 * The class doesn't provide additional methods and serves as marker for 
 * the NetBeans RCP to distinguish between other classes that implement
 * {@link EntityService } .
 * 
 * @see org.cdms.entities.ProductItem
 * @author V. Shyshkin
 */
public interface ProductItemService<E extends ProductItem> extends EntityService<E>{

}
