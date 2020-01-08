package com.example.demomySQL.model;

import java.math.BigDecimal;
import java.math.BigInteger;

public class GroupProductsTable {
    String group;
    BigInteger productsCount;
    BigDecimal productsPrice;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public BigInteger getProductsCount() {
        return productsCount;
    }

    public void setProductsCount(BigInteger productsCount) {
        this.productsCount = productsCount;
    }

    public BigDecimal getProductsPrice() {
        return productsPrice;
    }

    public void setProductsPrice(BigDecimal productsPrice) {
        this.productsPrice = productsPrice;
    }

    @Override
    public String toString() {
        return "{" +
                "group='" + group + '\'' +
                ", associatedProductsCount=" + productsCount +
                ", productsPriceSum=" + productsPrice +
                '}';
    }

    public GroupProductsTable(String group, BigInteger productsCount, BigDecimal productsPrice){
        this.group = group;
        this.productsCount = productsCount;
        this.productsPrice = productsPrice;
    }
}
