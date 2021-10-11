/**
 * Class which is used to
 *
 * @author Tarun Rohila
 */
package de.tech26.robotfactory.controller;

import de.tech26.robotfactory.dto.RobotOrderRequest;
import de.tech26.robotfactory.service.RobotOrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static de.tech26.robotfactory.constant.RestRequestConstants.ORDERS_ENDPOINT;

/**
 * Class which is used to handle endpoints for robot order request
 *
 * @author Tarun Rohila
 */
@RestController
@RequestMapping(ORDERS_ENDPOINT)
public class RobotOrderController {
    /**
     * Logger declaration.
     */
    private static final Logger LOGGER = LogManager.getLogger(RobotOrderController.class);

    /**
     * Autowired instance of robotOrderService
     */
    @Autowired
    @Qualifier("robotOrderService")
    private RobotOrderService robotOrderService;

    /**
     * Method to order a valid robot
     *
     * @param robotOrderRequest - robotOrderRequest
     * @return an ordered robot with price and order id
     */
    @PostMapping
    public ResponseEntity<?> orderRobot(@Valid @RequestBody RobotOrderRequest robotOrderRequest) {
        LOGGER.debug("Ordering a robot from a robot factory");
        return new ResponseEntity<>(robotOrderService.placeOrder(robotOrderRequest), HttpStatus.CREATED);
    }
}
