package com.oop.project.controller.gestor;

import com.oop.project.model.product.Product;
import com.oop.project.model.user.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SingletonData {

    private Map<Integer, User> users;
    private AtomicInteger usersId;

    private Map<Integer, Product> products;
    private AtomicInteger productsId;

    private static SingletonData singletonData;

    private SingletonData() {
        users = new ConcurrentHashMap<>();
        usersId = new AtomicInteger(1);
        products = new ConcurrentHashMap<>();
        productsId = new AtomicInteger(1);
    }

    public static SingletonData getSingletonInstance() {
        if (singletonData == null){
            singletonData = new SingletonData();
        }
        return singletonData;
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public void setUsers(Map<Integer, User> users) {
        this.users = users;
    }

    public AtomicInteger getUsersId() {
        return usersId;
    }

    public void setUsersId(AtomicInteger usersId) {
        this.usersId = usersId;
    }

    public Map<Integer, Product> getProducts() {
        return products;
    }

    public void setProducts(Map<Integer, Product> products) {
        this.products = products;
    }

    public AtomicInteger getProductsId() {
        return productsId;
    }

    public void setProductsId(AtomicInteger productsId) {
        this.productsId = productsId;
    }
}

