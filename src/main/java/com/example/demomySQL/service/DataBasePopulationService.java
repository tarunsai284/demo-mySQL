package com.example.demomySQL.service;

import com.example.demomySQL.dao.GroupRepo;
import com.example.demomySQL.dao.ProductRepo;
import com.example.demomySQL.model.GroupModel;
import com.example.demomySQL.model.ProductsModel;
import com.example.demomySQL.utils.ApplicationConstants;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

@Service
public class DataBasePopulationService implements ApplicationConstants {

    @Autowired
    GroupRepo groupRepo;

    @Autowired
    ProductRepo productRepo;

    public void processFile(MultipartFile product_list, MultipartFile group_list) throws IOException {
        CSVParser productParser  = CSVFormat.EXCEL.withHeader().parse(new InputStreamReader(product_list.getInputStream()));
        CSVParser groupParser  = CSVFormat.EXCEL.withHeader().parse(new InputStreamReader(group_list.getInputStream()));

        for (CSVRecord groupRecord : groupParser) {
            // Accessing values by Header names
            String name = groupRecord.get("group name");
            String description = groupRecord.get("group description");
            String isActive = groupRecord.get("isActive");
            GroupModel groupModel = insertGroup(name,description,isActive);
        }

        for (CSVRecord csvRecord : productParser) {
            // Accessing values by Header names
            String name = csvRecord.get("Product Name");
            String model = csvRecord.get("Model Name");
            long serial_no = Long.valueOf(csvRecord.get("Product Serial No"));
            String group_associated = csvRecord.get("Group Associated");
            int mrp = Integer.valueOf(csvRecord.get("product MRP (rs.)"));
            insertProduct(name, model, serial_no, group_associated, mrp);
        }
    }

    private void insertProduct(String name, String model, long serial_no, String group_associated, int mrp) {
        Optional<GroupModel> group = groupRepo.findById(group_associated);
        if(group.isPresent()) {
            ProductsModel productsModel = new ProductsModel();
            productsModel.setSerialNo(serial_no);
            productsModel.setProductName(name);
            productsModel.setModelName(model);
            productsModel.setMrp(mrp);
            productsModel.setGroupModel(group.get());
            productRepo.save(productsModel);
        }
    }

    private GroupModel insertGroup(String group, String description, String activity) {
        GroupModel groupModel = new GroupModel();
        groupModel.setGroupName(group);
        groupModel.setDescription(description);
        groupModel.setIsActive(activity);
        groupRepo.save(groupModel);
        return groupModel;
    }


}
