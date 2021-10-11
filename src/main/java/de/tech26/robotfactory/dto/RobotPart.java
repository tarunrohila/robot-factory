package de.tech26.robotfactory.dto;

/**
 * Class which is used to create an object of {@link RobotPart}
 *
 * @author Tarun Rohila
 */
public class RobotPart {

    /**
     * Variable declaration for code
     */
    private String code;

    /**
     * Variable declaration for price
     */
    private double price;

    /**
     * Variable declaration for available
     */
    private long available;

    /**
     * Variable declaration for part
     */
    private String part;

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
     * Method to get the value of price
     *
     * @return price - price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Method to set the value of price
     *
     * @param price - price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Method to get the value of available
     *
     * @return available - available
     */
    public long getAvailable() {
        return available;
    }

    /**
     * Method to set the value of available
     *
     * @param available - available
     */
    public void setAvailable(long available) {
        this.available = available;
    }

    /**
     * Method to get the value of part
     *
     * @return part - part
     */
    public String getPart() {
        return part;
    }

    /**
     * Method to set the value of part
     *
     * @param part - part
     */
    public void setPart(String part) {
        this.part = part;
    }
}
