package org.cdms.remoting;

import java.util.List;
import org.cdms.entities.Customer;

/**
 *
 * @author V. Shyshkin
 */
public interface CustomerService {

    Customer findById(long userId);
    //List<Customer> findByExample(Customer sample, long firstRecordMaxId,int pageSize);    
    QueryPage<Customer> findByExample(QueryPage<Customer> queryPage );    
    Customer insert(Customer customer);
    Customer update(Customer customer);
    Customer delete(long id);
    
}
