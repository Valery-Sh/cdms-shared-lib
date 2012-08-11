package org.cdms.remoting.exception;


/*ClassName = com.caucho.hessian.client.HessianRuntimeException
 --- msg = java.net.ConnectException: Connection refused: connect
Cause ClassName = java.net.ConnectException
 --- cause msg=Connection refused: connect
 */ 
/**
 *
 * @author Valery
 */
public class RemoteConnectionException extends RuntimeException{
    /**
     * A fully qualified class name of the actual exception 
     */
    private String originalClassName;
    private String causeClassName;
    private String causeMessage;

    private String serviceName;    
    private String serviceMethodName;
    private String entityName;
    // for HibernateQueryException & HibernateJdbcException.getSql()

    public RemoteConnectionException(String message) {
        super(message);
    }

    public String getOriginalClassName() {
        return originalClassName;
    }

    public void setOriginalClassName(String originalClassName) {
        this.originalClassName = originalClassName;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceMethodName() {
        return serviceMethodName;
    }

    public void setServiceMethodName(String serviceMethodName) {
        this.serviceMethodName = serviceMethodName;
    }

    public String getCauseClassName() {
        return causeClassName;
    }

    public void setCauseClassName(String causeClassName) {
        this.causeClassName = causeClassName;
    }

    public String getCauseMessage() {
        return causeMessage;
    }

    public void setCauseMessage(String causeMessage) {
        this.causeMessage = causeMessage;
    }


}
