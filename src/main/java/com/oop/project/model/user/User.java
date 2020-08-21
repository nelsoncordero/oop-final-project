package com.oop.project.model.user;

import com.oop.project.common.exception.*;
import com.oop.project.common.validation.IValidationStrategy;
import com.oop.project.common.validation.NotNullOrEmptyValidation;
import com.oop.project.common.validation.ValidationContext;
import com.oop.project.common.validation.EmailValidation;

import java.util.ArrayList;
import java.util.List;

public class User {

    private Integer id;
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void validate() throws InvalidDataException {
        List<IValidationStrategy> validationStrategies = new ArrayList<>();
        validationStrategies.add(new NotNullOrEmptyValidation("name", this.name));
        validationStrategies.add(new NotNullOrEmptyValidation("email", this.email));
        validationStrategies.add(new EmailValidation("email", this.email));
        ValidationContext context = new ValidationContext(validationStrategies);
        context.validation();
    }

}
