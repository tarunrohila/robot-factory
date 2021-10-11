package de.tech26.robotfactory.constant;

/**
 * Enum which is used to create constants for error codes
 *
 * @author Tarun Rohila
 */
public enum ErrorCodes {

    /**
     * All error codes
     */
    BAD_REQUEST_ERROR("API_INT_001", "BAD_REQUEST"),
    UNPROCESSABLE_ENTITY_ERROR("API_INT_002", "UNPROCESSABLE_ENTITY"),
    INTERNAL_SERVER_ERROR("API_INT_003", "INTERNAL_SERVER_ERROR");

    /**
     * Variable declaration for code
     */
    public String code;

    /**
     * Variable declaration for detail
     */
    public String title;

    /**
     * Method to set error code
     *
     * @param code - code
     */
    private ErrorCodes(String code) {
        this.code = code;
    }

    /**
     * Method to set error code and details
     *
     * @param code - code
     */
    private ErrorCodes(String code, String title) {
        this.code = code;
        this.title = title;
    }

    /**
     * Method to get the value of code
     *
     * @return code - code
     */
    public String getCode() {
        return code;
    }

    /**
     * Method to get the value of title
     *
     * @return title - title
     */
    public String getTitle() {
        return title;
    }
}
