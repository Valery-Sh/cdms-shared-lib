package org.cdms.remoting;

/**
 * Defines  <code>insert,update, delete</code> and <code>find</code> functionality.
 * 
 * @author V. Shyshkin
 */
public interface EntityService<E> {
    /**
     * Performs search <i>by example</i> for a given object of type 
     * <code>QuertPage</code>.
     * 
     * @param queryPage the object of type {@link org.cdms.remoting.QueryPage } that
     *   contains the current paging info and an instance of <i>example</i> class
     * @return the object of type <code>QueryPage</code> than contains search 
     *    results and updated paging data
     * 
     * @see org.cdms.remoting.QueryPage
     */
    QueryPage<E> findByExample(QueryPage<E> queryPage );    
    /**
     * Inserts the specified entity into the corresponding database table.
     * @param entity the entity to be inserted
     * @return the inserted entity that already contains the entity's 
     *   <code>id</code> and <code>verssion</code>
     */
    E insert(E entity);
    /**
     * Updates the specified entity in the corresponding database table.
     * @param entity the entity to be updated
     * @return the updated entity that already contains the entity's 
     *   <code>id</code> and <code>verssion</code>
     */
    E update(E entity);
    /**
     * Deletes the specified entity from the corresponding database table.
     * @param entity the entity to be deleted
     * @return the deleted entity
     */
    E delete(E entity);
    /**
     * Deletes the entity with the specified identifier from the corresponding database table.
     * @param id the id of the entity to be deleted
     * @return the deleted entity
     */
    E deleteById(Long id);
    
}
