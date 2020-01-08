package com.example.demomySQL.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "group_listing")
public class GroupModel {

    @Id
    @Column(name="group_name", nullable = false)
    String groupName;

    @Size(max = 20)
    @Column(name="group_description")
    String description;

    @Size(max = 20)
    @Column(name="is_active")
    String isActive;

    @OneToMany(mappedBy = "groupModel", cascade = CascadeType.ALL)
    Set<ProductsModel> productsModel;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Set<ProductsModel> getProductsModel() {
        return productsModel;
    }

    public void setProductsModel(Set<ProductsModel> productsModel) {
        this.productsModel = productsModel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }
}
