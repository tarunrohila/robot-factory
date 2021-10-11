package de.tech26.robotfactory.service;

import de.tech26.robotfactory.dto.Robot;
import de.tech26.robotfactory.dto.RobotPart;
import de.tech26.robotfactory.dto.RobotStock;

/**
 * Interface which is used to provide methods to control Robot Inventory
 *
 * @author Tarun Rohila
 */
public interface RobotInventoryService {

    /**
     * Method to get robot Parts
     *
     * @param code - code
     * @return robot parts
     */
    RobotPart getRobotParts(String code);

    /**
     * Method to load Robot Inventory
     *
     * @param robotStock - robotStock
     */
    void loadRobotInventory(RobotStock robotStock);

    /**
     * Method to update robot inventory
     *
     * @param robot - robot
     */
    void updateRobotStockInventory(Robot robot);
}
