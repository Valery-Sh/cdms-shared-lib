package org.cdms.remoting;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The class is used to organize paging of search results.
 * In addition, the class it is as a container that contains 
 * parameters and a return value when calling the search method.
 * 
 * @author V. Shyshkin
 */
public class QueryPage<T> implements Serializable {
    //
    // int constants insted of enum since not all  communication protocols support enmun
    //

    public static final int SEARCH = 0;   // search operation
    public static final int REFRESH = 10; // perform the same request for the same page 
    public static final int FIRST = 20;   // goto the first page
    public static final int PRIOR = 30;   // goto the previous page
    public static final int NEXT = 40;    // goto the next page
    public static final int LAST = 50;    // goto the last page
    
    private int navigateOperation;
    private List<T> queryResult;  // the result of a search operation. 
    private int pageNo;           // the current page
    private int pageSize;         // the 
    private long rowCount;
    private T entityAsExample;    // the object that contains an entity class
                                  // instance which used for query for example
    private Object[] params;       
    /**
     * Creates a new instance of the class and initializes the 
     * <code>queryResult</code> with an empty object of type 
     * <code>java.util.ArrayList</code>.
     */
    public QueryPage() {
        queryResult = new ArrayList<T>();
    }
    /**
     * The value of the property  set on the server after a search operation.
     * 
     * @return the result of a search operation
     */
    public List<T> getQueryResult() {
        return queryResult;
    }
    /**
     * The <code>setter</code> method of the property <code>queryResult</code>.
     * @param queryResult 
     */
    public void setQueryResult(List<T> queryResult) {
        this.queryResult = queryResult;
    }
    /**
     * The page number sets before a search or a navigate operation. 
     * @return the current page number. 
     */
    public int getPageNo() {
        return pageNo;
    }
    /**
     * The <code>setter</code> method of the property <code>pageNo</code>.
     * The page number sets before a search or a navigate operation. 
     * @param pageNo 
     */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }
    /**
     * The <code>setter</code> method of the property <code>pageSize</code>.
     * 
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getRowCount() {
        return rowCount;
    }
    /**
     * The <code>setter</code> method of the property <code>rowCount</code>.
     * The page number sets on the server side and neve on the client. 
     * @param pageRowCount
     */
    public void setRowCount(long rowCount) {
        this.rowCount = rowCount;
    }
    /**
     * Returns an entity instance which serves as a parameter to 
     * <i>find by example</i> operations.
     * @return the instance of the entity class.
     */
    public T getEntityAsExample() {
        return entityAsExample;
    }
    /**
     * Sets the specified entity as a value of the property 
     * <code>entityAsExample</code>.
     * @param entityAsExample the value to be set
     */
    public void setEntityAsExample(T entityAsExample) {
        this.entityAsExample = entityAsExample;
    }
    /**
     * Returns a search operation parameters as an array of 
     * <code>java.lang.Object</code>.
     * For example, statistics module uses it to send additional
     * parameters such as selected Customer identifier.
     * 
     * @return the array of objects
     */
    public Object[] getParams() {
        return params;
    }
    /**
     * Sets the specified array of objects as a value of the property 
     * <code>params</code>.
     * For example, statistics module uses it to send additional
     * parameters such as selected Customer identifier.
     * @param params 
     */
    public void setParams(Object[] params) {
        this.params = params;
    }
    /**
     * Returns the integer code of just initiated the search or navigate 
     * operation.
     * 
     * @return the value of the one of the static integer constants: 
     *      SEARCH,REFRESH,FIRST,PRIOR,NEXT,LAST
     */
    public int getNavigateOperation() {
        return navigateOperation;
    }
    /**
     * Sets a new value of the property <code>navigateOperation</code>.
     * The value may be set only on the client side.
     * As a side effect the method modifies the value of the property 
     * <code>pageNo</code> according to the new value of the 
     * <code>navigateOperation</code>.
     * 
     * @param navigateOperation 
     */
    public void setNavigateOperation(int navigateOperation) {
        switch (navigateOperation) {
            case SEARCH:
            case FIRST:
                pageNo = 0;
                break;
            case NEXT:
                pageNo++;
                break;
            case PRIOR:
                pageNo--;
                break;
            case LAST:
                int lastPage = (int) (getRowCount() / getPageSize() - 1);
                if (getRowCount() % getPageSize() != 0) {
                    lastPage++;
                }
                pageNo = lastPage;
                break;
        }
        this.navigateOperation = navigateOperation;
    }
}//class
