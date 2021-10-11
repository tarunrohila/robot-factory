package de.tech26.robotfactory.dto;

/**
 * Class which is used to create an object for {@link ErrorResponse}
 *
 * @author Tarun Rohila
 */
public class ErrorResponse {
    /**
     * Variable declaration for code
     */
    private String code;

    /**
     * Variable declaration for title
     */
    private String title;

    /**
     * Variable declaration for description
     */
    private String description;

    /**
     * Method to get the value of code
     *
     * @return code - code
     */
    public String getCode() {
        return code;
    }

    /**
     * Method to set the value of code
     *
     * @param code - code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Method to get the value of title
     *
     * @return title - title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Method to set the value of title
     *
     * @param title - title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Method to get the value of description
     *
     * @return description - description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method to set the value of description
     *
     * @param description - description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
