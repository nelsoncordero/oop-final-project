package com.oop.project.controller.response;

import java.util.List;

public class EntityResponse<T,T1> extends Response{

    private Boolean success;
    private T1 data;

    public EntityResponse(T status, Boolean success, T1 data) {
        super(status);
        this.success = success;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T1 getData() {
        return data;
    }

    public void setData(T1 data) {
        this.data = data;
    }
}