package org.cdms.remoting;

import java.util.List;
import org.cdms.entities.Customer;

/**
 *
 * @author V. Shyshkin
 */
public interface CustomerService {

    Customer findById(long userId);
    List<Customer> findByExample(Customer sample, int start,int pageSize);    
    void insert(Customer customer);
    void update(Customer customer);
    void delete(long id);
    
}
