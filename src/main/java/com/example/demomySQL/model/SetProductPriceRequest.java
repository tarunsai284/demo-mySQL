package com.example.demomySQL.model;

import javax.validation.constraints.NotNull;

public class SetProductPriceRequest {

    @NotNull
    int price;

    @NotNull
    long serialNo;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(long serialNo) {
        this.serialNo = serialNo;
    }

    @Override
    public String toString() {
        return "SetProductPriceRequest{" +
                "price=" + price +
                ", serialNo=" + serialNo +
                '}';
    }
}
