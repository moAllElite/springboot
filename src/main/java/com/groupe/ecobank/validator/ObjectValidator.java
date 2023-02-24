package com.groupe.ecobank.validator;

import com.groupe.ecobank.exceptions.ObjectValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Set;
import java.util.stream.Collectors;


public class ObjectValidator <T>{
    private final ValidatorFactory factory=Validation.buildDefaultValidatorFactory();
    private final Validator validator= factory.getValidator();
    public void validate(T objectToValidate){
        Set<ConstraintViolation<T>>  violations=validator.validate(objectToValidate);
        if (!violations.isEmpty()){
            Set <String> errorMessages=violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toSet());
            //to do raise exception
            throw new ObjectValidationException(errorMessages,objectToValidate.getClass().getName());
        }
    }
}
