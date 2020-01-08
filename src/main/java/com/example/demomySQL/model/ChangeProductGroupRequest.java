package com.example.demomySQL.model;

import javax.validation.constraints.NotNull;

public class ChangeProductGroupRequest {

    @NotNull
    String groupName;

    @NotNull
    long serialNo;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public long getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(long serialNo) {
        this.serialNo = serialNo;
    }

    @Override
    public String toString() {
        return "changeProductGroupRequest{" +
                "groupName='" + groupName + '\'' +
                ", serialNo=" + serialNo +
                '}';
    }
}
