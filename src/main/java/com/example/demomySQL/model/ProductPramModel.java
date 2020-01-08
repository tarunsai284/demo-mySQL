package com.example.demomySQL.model;

import javax.validation.constraints.NotNull;

public class ProductPramModel {
    @NotNull
    Long serialNo;

    @NotNull
    String productName;

    @NotNull
    String modelName;

    @NotNull
    int mrp;

    @NotNull
    String groupName;

    public Long getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Long serialNo) {
        this.serialNo = serialNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getMrp() {
        return mrp;
    }

    public void setMrp(int mrp) {
        this.mrp = mrp;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "ProductPramModel{" +
                "serialNo=" + serialNo +
                ", productName='" + productName + '\'' +
                ", modelName='" + modelName + '\'' +
                ", mrp=" + mrp +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
