package org.cdms.remoting;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author V. Shyshkin
 */
public class QueryPage<T> implements Serializable{
    private List<T> queryResult;
    private int pageNo;
    private int pageSize;
    private long rowCount;
    private T entityAsExample;
    
    public QueryPage() {
        queryResult = new ArrayList<T>(); 
    }
    public QueryPage(int pageNo,int pageSize ) {
        this(pageNo, pageSize, 0);
    }
    
    public QueryPage(int pageNo,int pageSize,long rowCount ) {
        this();
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.rowCount = rowCount;
    }

    public List<T> getQueryResult() {
        return queryResult;
    }

    public void setQueryResult(List<T> queryResult) {
        this.queryResult = queryResult;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getRowCount() {
        return rowCount;
    }

    public void setRowCount(long rowCount) {
        this.rowCount = rowCount;
    }

    public T getEntityAsExample() {
        return entityAsExample;
    }

    public void setEntityAsExample(T entityAsExample) {
        this.entityAsExample = entityAsExample;
    }
    
}//
