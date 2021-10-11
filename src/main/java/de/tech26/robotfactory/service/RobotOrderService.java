package de.tech26.robotfactory.service;

import de.tech26.robotfactory.dto.RobotOrderRequest;
import de.tech26.robotfactory.dto.RobotOrderResponse;

/**
 * Interface which is used to handle request and business logic for robot order requests
 *
 * @author Tarun Rohila
 */
public interface RobotOrderService {

    /**
     * Method to place a new robot order
     *
     * @param robotOrderRequest - robotOrderRequest
     * @return robot order response
     */
    RobotOrderResponse placeOrder(RobotOrderRequest robotOrderRequest);
}
