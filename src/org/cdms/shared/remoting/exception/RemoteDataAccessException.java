package org.cdms.shared.remoting.exception;

/**
 * The class may be used to notify remote clients of the exceptions raised
 * on a remote server.
 * Suppose the remote client is a pure swing applications that knows
 * nothing of <code>Spring | Hibernate | JPA</code>. The application
 * communicates with a remote Spring-based server through Hessian
 * (or any other) RMI protocol. When the client 
 * invokes a remote method then an exceptions may occur on the server.
 * The server application translates the exception and transfers 
 * to the client an object of type <code>RemoteDataAccessException</code>
 * instead of the <i>native</i> one.
 * The class allows an exception that is thrown on the server side
 * be send back to the client independently of the used remote protocol.
 * The class corresponds the server side exception that represents 
 * errors associated with the Spring Framework Data Access.
 * 
 * @author Valery
 */
public class RemoteDataAccessException extends RuntimeException{
    public static final int OBJECT_RETRIEVAL = 0; //// mapped object could not be retrieved via its identifier
    public static final int OBJECT_RETRIEVAL_DELETE = 4; //// mapped object could not be retrieved via its identifier
    public static final int QUERY = 8; //bad SQL
    public static final int JDBC = 12; // something went wrong with the underlying resource
    public static final int SYSTEM = 16; // something went wrong with the underlying resource    
    public static final int OPTIMISTIC_LOCKING = 20;  //OptimisticLocking
    
    /**
     * A fully qualified class name of the actual exception 
     */
    private String originalClassName;
    // for HibernateObjectRetrievalFailureException
    private Object identifier;
    private String persistentClassName;
    private String entityName;
    // for HibernateQueryException & HibernateJdbcException.getSql()
    private String queryString;
    
    private int errorCode;
    public RemoteDataAccessException(String message) {
        super(message);
    }

    public String getOriginalClassName() {
        return originalClassName;
    }

    public void setOriginalClassName(String originalClassName) {
        this.originalClassName = originalClassName;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public Object getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Object identifier) {
        this.identifier = identifier;
    }

    public String getPersistentClassName() {
        return persistentClassName;
    }

    public void setPersistentClassName(String persistentClassName) {
        this.persistentClassName = persistentClassName;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }
    
}
