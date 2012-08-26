package org.cdms.shared.remoting.exception;

/**
 * The class allows an exception that is thrown on the server side
 * be send back to the client independently of the used remote protocol.
 * The class corresponds the server side exception that represent 
 * errors associated with server connections.
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
    /**
     * Creates a new instance of the class with the specified exception message.
     * @param message 
     */
    public RemoteConnectionException(String message) {
        super(message);
    }
    /**
     * @return a string value of the fully qualified class name of the exception that
     *   has been thrown on the server
     */
    public String getOriginalClassName() {
        return originalClassName;
    }
    /**
     * Sets a string value of the fully qualified class name of the exception that
     *   has been thrown on the server
     * @param originalClassName the class name to be set
     */
    public void setOriginalClassName(String originalClassName) {
        this.originalClassName = originalClassName;
    }
    /**
     * @return the entity's class name that is involved in an operation that
     *   caused the exception. May be <code>null</code>.
     */
    public String getEntityName() {
        return entityName;
    }
    /**
     * Sets the entity's class name that is involved in an operation that
     *   caused the exception
     */
    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }
    /**
     * @return the remote service name which  caused the exception. 
     * May be <code>null</code>.
     */
    public String getServiceName() {
        return serviceName;
    }
    /**
     * Sets the remote service name which  caused the exception. 
     * @param serviceName 
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    /**
     * @return the name of the method of the remote service which  caused the 
     * exception. 
     * May be <code>null</code>.
     */
    public String getServiceMethodName() {
        return serviceMethodName;
    }
    /**
     * Sets the name of the method of the remote service which  caused the 
     * exception. 
     * May be <code>null</code>.
     */
    public void setServiceMethodName(String serviceMethodName) {
        this.serviceMethodName = serviceMethodName;
    }
    /**
     * @return the string representation of the <code>Throwable</code>
     *   returned by the <code>getCause()</code> method of the 
     *   exception 
     */
    public String getCauseClassName() {
        return causeClassName;
    }
    /**
     * Sets the string representation of the <code>Throwable</code>
     *   returned by the <code>getCause()</code> method of the 
     *   exception 
     * @param causeClassName 
     */
    public void setCauseClassName(String causeClassName) {
        this.causeClassName = causeClassName;
    }
    /**
     * @return the message of the <code>Throwable</code>
     *   returned by the <code>getCause().getMessage()</code> method of the 
     *   exception 
     */
    public String getCauseMessage() {
        return causeMessage;
    }
    /**
     * Sets the message of the <code>Throwable</code>
     *   returned by the <code>getCause().getMessage()</code> method of the 
     *   exception 
     */
    public void setCauseMessage(String causeMessage) {
        this.causeMessage = causeMessage;
    }
}
