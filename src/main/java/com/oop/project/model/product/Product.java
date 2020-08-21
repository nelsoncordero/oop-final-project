package com.oop.project.model.product;

import com.oop.project.common.validation.*;
import com.oop.project.model.user.User;
import com.oop.project.common.exception.*;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private Integer id;
    private String name;
    private Integer quantity;
    @Nullable
    private User seller;

    public Product(String name, Integer quantity, User seller) {
        this.name = name;
        this.quantity = quantity;
        this.seller = seller;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public void validate() throws InvalidDataException {
        List<IValidationStrategy> validationStrategies = new ArrayList<>();
        validationStrategies.add(new NotNullOrEmptyValidation("name", this.name));
        validationStrategies.add(new QuantityValidation("quantity", this.quantity));
        ValidationContext context = new ValidationContext(validationStrategies);
        context.validation();
    }
}
