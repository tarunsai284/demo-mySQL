package com.example.demomySQL.utils;

public class Response {
    int status;
    String errorMsg;
    String statusMsg;
    Object Data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public Object getData() {
        return Data;
    }

    public void setData(Object data) {
        Data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "status=" + status +
                ", errorMsg='" + errorMsg + '\'' +
                ", statusMsg='" + statusMsg + '\'' +
                ", Data=" + Data +
                '}';
    }

}
