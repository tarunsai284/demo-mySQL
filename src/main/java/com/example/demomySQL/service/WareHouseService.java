package com.example.demomySQL.service;

import com.example.demomySQL.dao.GroupRepo;
import com.example.demomySQL.dao.ProductRepo;
import com.example.demomySQL.model.GroupModel;
import com.example.demomySQL.model.GroupProductsTable;
import com.example.demomySQL.model.ProductPramModel;
import com.example.demomySQL.model.ProductsModel;
import com.example.demomySQL.utils.ApplicationConstants;
import com.example.demomySQL.utils.NoSuchRowException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WareHouseService implements ApplicationConstants {

    @Autowired
    GroupRepo groupRepo;

    @Autowired
    ProductRepo productRepo;

    public void updatePrice(int price, long serialNo) throws NoSuchRowException {
        Optional<ProductsModel> product = productRepo.findById(serialNo);
        if(product.isPresent()){
            product.get().setMrp(price);
            productRepo.save(product.get());
        }else throw new NoSuchRowException("No record found for product with serial_no: "+ serialNo);
    }

    public void addProduct(ProductPramModel productParam) throws Exception {
        Optional<ProductsModel> product = productRepo.findById(productParam.getSerialNo());
        if(!product.isEmpty()) throw new Exception("Product with this serial_no: "+productParam.getSerialNo()+ " already exists");

        String groupName = productParam.getGroupName();
        Optional<GroupModel> group = groupRepo.findById(groupName);

        if(group.isEmpty()) group = insertGroup(groupName, null, GROUP_ACTIVE_YES);

        ProductsModel productsModel = new ProductsModel();
        productsModel.setSerialNo(productParam.getSerialNo());
        productsModel.setProductName(productParam.getProductName());
        productsModel.setModelName(productParam.getModelName());
        productsModel.setMrp(productParam.getMrp());
        productsModel.setGroupModel(group.get());
        productRepo.save(productsModel);
    }

    public void changeProductGroup(String groupName, long serialNo) {
        Optional<GroupModel> group = groupRepo.findById(groupName);
        if(group.isEmpty()) group = insertGroup(groupName, null, GROUP_ACTIVE_YES);
        Optional<ProductsModel> product = productRepo.findById(serialNo);
        product.get().setGroupModel(group.get());
        productRepo.save(product.get());
    }

    public List<GroupProductsTable> getGroupProducts() {
        List<Object> groupObjects = productRepo.fetchGroupProducts();
        List<GroupProductsTable> groupTable = new ArrayList<>();
        for(Object obj : groupObjects){
            ObjectMapper mapper = new ObjectMapper();
            List<Object> arrayObj = mapper.convertValue(obj,List.class);
            GroupProductsTable row = new GroupProductsTable(arrayObj.get(0).toString(), (BigInteger) arrayObj.get(1), (BigDecimal) arrayObj.get(2));
            groupTable.add(row);
        }
        return groupTable;
    }

    private Optional<GroupModel> insertGroup(String group, String description, String activity) {
        System.out.println("Adding new group");
        System.out.println("group: "+group+", description: "+ description+", activity: "+ activity);
        GroupModel groupModel = new GroupModel();
        groupModel.setGroupName(group);
        groupModel.setDescription(description);
        groupModel.setIsActive(activity);
        groupRepo.save(groupModel);
        return Optional.of(groupModel);
    }

    public List<ProductsModel> getProductRepo() {
        return productRepo.findAll();
    }
}
