package de.tech26.robotfactory.validator;

import de.tech26.robotfactory.dto.RobotOrderRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Class which is used to create a custo robot request validator
 *
 * @author Tarun Rohila
 */
public class RobotRequestValidator implements ConstraintValidator<RobotRequest, RobotOrderRequest> {

    /**
     * metho to check if robot request is valid
     *
     * @param o                          - robot request
     * @param constraintValidatorContext validator context
     * @return true if request is valid
     */
    @Override
    public boolean isValid(RobotOrderRequest o, ConstraintValidatorContext constraintValidatorContext) {
        if (o.getComponents().size() != 4) {
            return false;
        }
        return true;
    }
}
