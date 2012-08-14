/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cdms.remoting;

/**
 *
 * @author Valery
 */
public interface EntityService<E> {
    E findById(long userId);
    //List<Invoice> findByExample(Invoice sample, long firstRecordMaxId,int pageSize);    
    QueryPage<E> findByExample(QueryPage<E> queryPage );    
    E insert(E entity);
    E update(E entity);
    E delete(E entity);
    E deleteById(Long id);
    
}
