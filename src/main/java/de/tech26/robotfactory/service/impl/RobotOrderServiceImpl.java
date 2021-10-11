package de.tech26.robotfactory.service.impl;

import de.tech26.robotfactory.dto.*;
import de.tech26.robotfactory.exception.ApiRequestException;
import de.tech26.robotfactory.service.RobotInventoryService;
import de.tech26.robotfactory.service.RobotOrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * Class which is used to handle request and to keep business logic for robot order requests
 *
 * @author Tarun Rohila
 */
@Service("robotOrderService")
public class RobotOrderServiceImpl implements RobotOrderService {

    /**
     * Logger declaration.
     */
    private static final Logger LOGGER = LogManager.getLogger(RobotOrderServiceImpl.class);

    /**
     * Autowired dependency for {@link RobotInventoryService
     */
    @Autowired
    private RobotInventoryService robotInventoryService;

    /**
     * Method to place a new robot order
     *
     * @param robotOrderRequest - robotOrderRequest
     * @return robot order response
     */
    @Override
    public RobotOrderResponse placeOrder(RobotOrderRequest robotOrderRequest) {
        LOGGER.debug("Handling a new robot order request");
        final Robot.Builder robotBuilder = new Robot.Builder();
        robotOrderRequest.getComponents().stream().forEach(s -> {
            RobotPart robotPart = robotInventoryService.getRobotParts(s);
            if (robotPart.getPart().contains(RobotParts.FACE.getLabel()) && robotPart.getAvailable() > 0) {
                robotBuilder.face(robotPart);
            } else if (robotPart.getPart().contains(RobotParts.MATERIAL.getLabel()) && robotPart.getAvailable() > 0) {
                robotBuilder.material(robotPart);
            } else if (robotPart.getPart().contains(RobotParts.ARMS.getLabel()) && robotPart.getAvailable() > 0) {
                robotBuilder.arms(robotPart);
            } else if (robotPart.getPart().contains(RobotParts.MOBILITY.getLabel()) && robotPart.getAvailable() > 0) {
                robotBuilder.mobility(robotPart);
            } else {
                LOGGER.error("Failed to place a new robot order");
                throw new ApiRequestException("The parts of Robot in the Request is not available", HttpStatus.UNPROCESSABLE_ENTITY);
            }
        });
        Robot robot = robotBuilder.build();

        if (!Stream.of(robot.getFace(), robot.getMaterial(), robot.getArms(), robot.getMobility())
                .allMatch(Objects::isNull)) {
            return prepareRobotOrderResponse(robot);
        } else {
            LOGGER.error("Failed to place a new robot order");
            throw new ApiRequestException("Invalid Robot Order, and Order contains one, and only one, part of face, material, arms and mobility", HttpStatus.BAD_REQUEST);
        }

    }

    private RobotOrderResponse prepareRobotOrderResponse(Robot robot) {
        LOGGER.debug("Building a robot order response");
        RobotOrderResponse robotOrderResponse = new RobotOrderResponse();
        robotOrderResponse.setOrderId(UUID.randomUUID().toString());
        robotOrderResponse.setTotal(robot.getFace().getPrice() + robot.getMaterial().getPrice() + robot.getArms().getPrice() + robot.getMobility().getPrice());
        robotInventoryService.updateRobotStockInventory(robot);
        return robotOrderResponse;
    }
}
