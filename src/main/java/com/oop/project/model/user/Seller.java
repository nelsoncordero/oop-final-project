package com.oop.project.model.user;

import com.oop.project.model.product.Product;

import java.util.List;

public class Seller extends User{

    private List<Product> products;

    public Seller(String name, String email, List<Product> products) {
        super(name, email);
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
