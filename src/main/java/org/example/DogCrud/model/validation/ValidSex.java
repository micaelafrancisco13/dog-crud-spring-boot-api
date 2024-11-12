package org.example.DogCrud.model.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidSexValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidSex {
    String message() default "Invalid sex value";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default
    {};
}
