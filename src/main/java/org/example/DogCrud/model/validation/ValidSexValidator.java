package org.example.DogCrud.model.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.DogCrud.model.Dog;

public class ValidSexValidator implements ConstraintValidator<ValidSex, Dog.Sex> {

    @Override
    public boolean isValid(Dog.Sex sex, ConstraintValidatorContext context) {
        return (sex == Dog.Sex.FEMALE || sex == Dog.Sex.MALE);
    }
}