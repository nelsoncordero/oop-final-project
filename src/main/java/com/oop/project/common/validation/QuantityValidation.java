package com.oop.project.common.validation;

import com.oop.project.common.exception.*;

/**
 * @author HP
 * @version 1.1
 */
public class QuantityValidation implements IValidationStrategy {
    private Integer value;
    private String field;

    public QuantityValidation(String field, Integer value) {
        this.field = field;
        this.value = value;
    }

    @Override
    public void validate() throws InvalidDataException {
        if (this.value <= 0) {
            throw new InvalidDataException("Invalid Quantity of Product");
        }
    }
}
