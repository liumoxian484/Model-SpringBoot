package com.cdp.common.exception;

import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;



public class BusinessException extends RuntimeException {
    private Integer status = INTERNAL_SERVER_ERROR.value();

    public BusinessException(String msg){
        super(msg);
    }

    public BusinessException(HttpStatus status, String msg){
        super(msg);
        this.status = status.value();
    }
}
