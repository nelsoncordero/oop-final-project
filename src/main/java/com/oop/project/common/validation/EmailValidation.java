package com.oop.project.common.validation;

import com.oop.project.common.exception.*;

/**
 * @author HP
 * @version 1.1
 */
public class EmailValidation implements IValidationStrategy {
    private String value;
    private String field;

    public EmailValidation(String field, String value) {
        this.field = field;
        this.value = value;
    }

    @Override
    public void validate() throws InvalidDataException {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if (!value.matches(regex)) {
            throw new InvalidDataException("Email Invalid Format");
        }
    }
}
