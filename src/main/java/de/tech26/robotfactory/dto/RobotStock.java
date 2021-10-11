package de.tech26.robotfactory.dto;

import java.util.HashMap;

/**
 * Class which is used to create an object for {@link RobotStock}
 *
 * @author Tarun Rohila
 */
public class RobotStock {

    /**
     * Variable declaration for robotStock
     */
    private HashMap<String, RobotPart> robotStock;

    /**
     * Method to get the value of robotStock
     *
     * @return robotStock - robotStock
     */
    public HashMap<String, RobotPart> getRobotStock() {
        return robotStock;
    }

    /**
     * Method to set the value of robotStock
     *
     * @param robotStock - robotStock
     */
    public void setRobotStock(HashMap<String, RobotPart> robotStock) {
        this.robotStock = robotStock;
    }
}
