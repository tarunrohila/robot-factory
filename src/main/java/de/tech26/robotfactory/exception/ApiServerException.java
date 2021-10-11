package de.tech26.robotfactory.exception;

/**
 * Class which is used to create custom exception for service errors
 *
 * @author Tarun Rohila
 */
public class ApiServerException extends RuntimeException {

    /**
     * Constructor declaration with message param
     */
    public ApiServerException(String message) {
        super(message);
    }

    /**
     * Constructor declaration with throwable param
     */
    public ApiServerException(Throwable t) {
        super(t);
    }

    /**
     * Constructor declaration with message and throwable param
     */
    public ApiServerException(String message, Throwable t) {
        super(message, t);
    }
}
