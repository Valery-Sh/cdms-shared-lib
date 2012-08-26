package org.cdms.shared.remoting;

import org.cdms.shared.entities.Customer;

/**
 * Defines  <code>insert,update, delete</code> and <code>find</code> functionality
 * for the <code>Customer</code> class.
 * The class doesn't provide additional methods and serves as marker for 
 * the NetBeans RCP to distinguish between other classes that implement
 * {@link EntityService } .
 * 
 * @see org.cdms.entities.Customer
 * @author V. Shyshkin
 */
public interface CustomerService<E extends Customer> extends EntityService<E>{
}
