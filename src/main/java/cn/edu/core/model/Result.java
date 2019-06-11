package cn.edu.core.model;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonView;


public class Result {

    private int code;
    private String message;
    private Object data;

    /**
     *
     * @param data
     * @return
     */
    public void setErrorMessage(String message, Object data) {
        this.code = 400;
        this.message = message;
        this.data = data;
    }

    public void setSucessMessage(String message, Object data) {
        this.code =200;
        this.message = message;
        this.data = data;
    }

    public interface DefulatJsonView{}


    @JsonView(DefulatJsonView.class)
    public int getCode() {
        return code;
    }

    @JsonView(DefulatJsonView.class)
    public String getMessage() {
        return message;
    }

    @JsonView(DefulatJsonView.class)
    public Object getData() {
        return data;
    }

    public Result setData(Object data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
