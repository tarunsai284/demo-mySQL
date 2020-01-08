package com.example.demomySQL.utils;

public class NoSuchRowException extends Exception {

    String errorMsg;

    public NoSuchRowException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    @Override
    public String getMessage() {
        return errorMsg;
    }
}
