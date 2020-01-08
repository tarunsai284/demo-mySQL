package com.example.demomySQL.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "products")
public class ProductsModel {

    @Id
    @Column(name="serial_no")
    Long serialNo;

    @Size(max = 20)
    @Column(name="product_name")
    String productName;

    @Size(max = 20)
    @Column(name="model_name")
    String modelName;

    @Column(name="mrp")
    int mrp;

    @ManyToOne
    @JoinColumn(name="group_associated")
    GroupModel groupModel;

    public long getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(long serialNo) {
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

    public GroupModel getGroupModel() {
        return groupModel;
    }

    public void setGroupModel(GroupModel groupModel) {
        this.groupModel = groupModel;
    }

    public int getMrp() {
        return mrp;
    }

    public void setMrp(int mrp) {
        this.mrp = mrp;
    }

    @Override
    public String toString() {
        return "ProductsModel{" +
                "serialNo=" + serialNo +
                ", productName='" + productName + '\'' +
                ", modelName='" + modelName + '\'' +
                ", mrp=" + mrp +
                ", groupModel=" + groupModel +
                '}';
    }
}
