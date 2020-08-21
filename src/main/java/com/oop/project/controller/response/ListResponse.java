package com.oop.project.controller.response;

import java.util.List;

public class ListResponse<T,T1> extends Response{

    private Boolean success;
    private Integer count;
    private List<T1> data;

    public ListResponse(T status, Boolean success, Integer count, List<T1> data) {
        super(status);
        this.success = success;
        this.count = count;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T1> getData() {
        return data;
    }

    public void setData(List<T1> data) {
        this.data = data;
    }
}