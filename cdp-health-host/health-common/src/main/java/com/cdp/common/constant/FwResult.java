package com.cdp.common.constant;
import com.cdp.common.enums.StatusEnum;

import java.io.Serializable;


public class FwResult<T> implements Serializable {

    private int code;

    private String msg;

    private T data;

    private long totalTime;

    private FwResult(StatusEnum statusEnum) {
        this.code = statusEnum.getValue();
        this.msg = statusEnum.getDesc();
    }

    private FwResult(StatusEnum statusEnum,T data) {
        this.code = statusEnum.getValue();
        this.msg = statusEnum.getDesc();
        this.data = data;
    }

    private FwResult(StatusEnum statusEnum,String msg) {
        this.code = statusEnum.getValue();
        this.msg = msg;
    }

    private FwResult(StatusEnum statusEnum,String msg,T data) {
        this.code = statusEnum.getValue();
        this.msg = msg;
        this.data = data;
    }

    public static FwResult success() {
        return new FwResult(StatusEnum.SUCCESS);
    }
    public static FwResult error() {
        return new FwResult(StatusEnum.ERROR);
    }
    public static FwResult build(StatusEnum statusEnum) {
        return new FwResult(statusEnum);
    }
    public static<T> FwResult<T> build(StatusEnum statusEnum,T data) {
        return new FwResult(statusEnum,data);
    }
    public static FwResult build(StatusEnum statusEnum,String msg) {
        return new FwResult(statusEnum,msg);
    }
    public static<T> FwResult<T> build(StatusEnum statusEnum,String msg,T data) {
        return new FwResult(statusEnum,msg,data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(long totalTime) {
        this.totalTime = totalTime;
    }

}
