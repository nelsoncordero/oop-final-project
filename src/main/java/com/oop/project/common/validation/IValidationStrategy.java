package com.oop.project.common.validation;

import com.oop.project.common.exception.*;

public interface IValidationStrategy {
    void validate() throws InvalidDataException;
}
