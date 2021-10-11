package de.tech26.robotfactory.exception;

import org.springframework.http.HttpStatus;

/**
 * Class which is used to create custom exception for request errors
 *
 * @author Tarun Rohila
 */
public class ApiRequestException extends RuntimeException {

    private HttpStatus httpStatus;

    /**
     * Constructor declaration with message param
     */
    public ApiRequestException(String message) {
        super(message);
    }

    /**
     * Constructor declaration with message param
     */
    public ApiRequestException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    /**
     * Constructor declaration with throwable param
     */
    public ApiRequestException(Throwable t) {
        super(t);
    }

    /**
     * Constructor declaration with message and throwable param
     */
    public ApiRequestException(String message, Throwable t) {
        super(message, t);
    }

    /**
     * Method to get the value of httpStatus
     *
     * @return httpStatus - httpStatus
     */
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    /**
     * Method to set the value of httpStatus
     *
     * @param httpStatus - httpStatus
     */
    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
