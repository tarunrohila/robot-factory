package de.tech26.robotfactory.service.impl;

import de.tech26.robotfactory.dto.Robot;
import de.tech26.robotfactory.dto.RobotPart;
import de.tech26.robotfactory.dto.RobotStock;
import de.tech26.robotfactory.service.RobotInventoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Class which is used to provide methods to control Robot Inventory
 *
 * @author Tarun Rohila
 */
@Service("robotInventoryService")
public class RobotInventoryServiceImpl implements RobotInventoryService {

    /**
     * Logger declaration.
     */
    private static final Logger LOGGER = LogManager.getLogger(RobotInventoryServiceImpl.class);

    /**
     * Variable declaration for robotStock
     */
    private RobotStock robotStock;

    /**
     * Method to get robot Parts
     *
     * @param code - code
     * @return robot parts
     */
    @Override
    public RobotPart getRobotParts(String code) {
        LOGGER.debug("Retrieving robot part for code = [{}]", code);
        return this.robotStock.getRobotStock().get(code);
    }

    /**
     * Method to load Robot Inventory
     *
     * @param robotStock - robotStock
     */
    @Override
    public void loadRobotInventory(RobotStock robotStock) {
        LOGGER.debug("Robot Stock Inventory is prepared");
        this.robotStock = robotStock;
    }

    /**
     * Method to update robot inventory
     *
     * @param robot - robot
     */
    @Override
    public void updateRobotStockInventory(Robot robot) {
        LOGGER.debug("updating inventory after a new robot is ordered");
        robotStock.getRobotStock().get(robot.getFace().getCode()).setAvailable(robot.getFace().getAvailable() - 1);
        robotStock.getRobotStock().get(robot.getMaterial().getCode()).setAvailable(robot.getMaterial().getAvailable() - 1);
        robotStock.getRobotStock().get(robot.getArms().getCode()).setAvailable(robot.getArms().getAvailable() - 1);
        robotStock.getRobotStock().get(robot.getMobility().getCode()).setAvailable(robot.getMobility().getAvailable() - 1);
        LOGGER.debug("Inventory is successfully updated");
    }

    /**
     * Method to get the value of robotStock
     *
     * @return robotStock - robotStock
     */
    public RobotStock getRobotStock() {
        return robotStock;
    }

    /**
     * Method to set the value of robotStock
     *
     * @param robotStock - robotStock
     */
    public void setRobotStock(RobotStock robotStock) {
        this.robotStock = robotStock;
    }
}
