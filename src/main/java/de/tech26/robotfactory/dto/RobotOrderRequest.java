package de.tech26.robotfactory.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import de.tech26.robotfactory.validator.RobotRequest;

import java.util.List;

/**
 * Class which is used to create an object of {@link RobotOrderRequest}
 *
 * @author Tarun Rohila
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@RobotRequest(message = "Invalid Robot Order, and Order contains one, and only one, part of face, material, arms and mobility")
public class RobotOrderRequest {

    /**
     * Variable declaration for components
     */
    private List<String> components;

    /**
     * Method to get the value of components
     *
     * @return components - components
     */
    public List<String> getComponents() {
        return components;
    }

    /**
     * Method to set the value of components
     *
     * @param components - components
     */
    public void setComponents(List<String> components) {
        this.components = components;
    }
}
