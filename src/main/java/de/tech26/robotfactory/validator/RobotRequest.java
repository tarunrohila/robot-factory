package de.tech26.robotfactory.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Interface which is used to create a custom validation annotation
 *
 * @author Tarun Rohila
 */
@Constraint(validatedBy = RobotRequestValidator.class)
@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Documented
public @interface RobotRequest {

    String message() default "{de.tech26.robotfactory.validator.RobotRequest.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
