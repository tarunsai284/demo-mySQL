package com.example.demomySQL;

import com.example.demomySQL.dao.GroupRepo;
import com.example.demomySQL.model.ProductsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoMySqlApplication {
/*	@Autowired
	GroupRepo groupRepo;

	@Autowired
	ProductsModel productsModel;*/

	public static void main(String[] args) {
		SpringApplication.run(DemoMySqlApplication.class, args);
	}

}
