package de.tech26.robotfactory.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class which is used to create an object of {@link RobotOrderResponse}
 *
 * @author Tarun Rohila
 */
public class RobotOrderResponse {

    /**
     * Variable declaration for orderId
     */
    @JsonProperty("order_id")
    private String orderId;

    /**
     * Variable declaration for total
     */
    private double total;

    /**
     * Method to get the value of orderId
     *
     * @return orderId - orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Method to set the value of orderId
     *
     * @param orderId - orderId
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * Method to get the value of total
     *
     * @return total - total
     */
    public double getTotal() {
        return total;
    }

    /**
     * Method to set the value of total
     *
     * @param total - total
     */
    public void setTotal(double total) {
        this.total = total;
    }
}
