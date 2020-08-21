package com.oop.project.controller.response;

/**
 * @author HP
 * @version 1.1
 */
public abstract class Response<T> {
    private T status;

    public Response(T status) {
        this.status = status;
    }

    public T getStatus() {
        return status;
    }

    public void setStatus(T status) {
        this.status = status;
    }
}
