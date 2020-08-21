package com.oop.project.controller.response;

/**
 * @author HP
 * @version 1.1
 */
public class ErrorResponse<T> extends Response {
    private String error;

    public ErrorResponse(T status, String error) {
        super(status);
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
