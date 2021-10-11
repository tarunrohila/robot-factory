package de.tech26.robotfactory.dto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Enum which is used to keep Robot Parts
 *
 * @author Tarun Rohila
 */
public enum RobotParts {
    FACE("Face"),
    MATERIAL("Material"),
    ARMS("Arms"),
    MOBILITY("Mobility");

    /**
     * Variable declaration for label
     */
    private String label;

    /**
     * Constructor declaration for RobotParts
     */
    RobotParts(String label) {
        this.label = label;
    }

    /**
     * Method to get the value of label
     *
     * @return label - label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Method to set the value of label
     *
     * @param label - label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    public static List<String> getRobotPartValues() {
        return Stream.of(RobotParts.values())
                .map(RobotParts::getLabel)
                .collect(Collectors.toList());
    }
}
