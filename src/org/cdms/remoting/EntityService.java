/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cdms.remoting;

/**
 *
 * @author Valery
 */
public interface EntityService<T> {
    T findById(long userId);
    //List<Invoice> findByExample(Invoice sample, long firstRecordMaxId,int pageSize);    
    QueryPage<T> findByExample(QueryPage<T> queryPage );    
    T insert(T customer);
    T update(T customer);
    T delete(long id);
    
}
