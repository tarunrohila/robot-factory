package de.tech26.robotfactory.exception;

import de.tech26.robotfactory.constant.ErrorCodes;
import de.tech26.robotfactory.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Class which is used to create global exception handler for the application
 *
 * @author Tarun Rohila
 */
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Method to handle api request exception
     *
     * @param ex - exception
     * @return error response entity
     */
    @ExceptionHandler(value
            = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestError(
            ApiRequestException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        if( ex.getHttpStatus().value() == 422) {
            errorResponse.setCode(ErrorCodes.UNPROCESSABLE_ENTITY_ERROR.getCode());
            errorResponse.setTitle(ErrorCodes.UNPROCESSABLE_ENTITY_ERROR.getTitle());
        } else {
            errorResponse.setCode(ErrorCodes.BAD_REQUEST_ERROR.getCode());
            errorResponse.setTitle(ErrorCodes.BAD_REQUEST_ERROR.getTitle());
        }
        errorResponse.setDescription(ex.getMessage());
        return new ResponseEntity<>(errorResponse, ex.getHttpStatus());
    }

    /**
     * Method to handle api server exception
     *
     * @param ex - exception
     * @return error response entity
     */
    @ExceptionHandler(value
            = {ApiServerException.class})
    public ResponseEntity<Object> handleApiServerError(
            ApiServerException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(ErrorCodes.INTERNAL_SERVER_ERROR.getCode());
        errorResponse.setTitle(ErrorCodes.INTERNAL_SERVER_ERROR.getTitle());
        errorResponse.setDescription(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
