package com.example.demomySQL.dao;

import com.example.demomySQL.model.ProductsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<ProductsModel, Long> {

    @Query(value ="SELECT p.group_associated, COUNT(p.product_name), SUM(p.mrp) FROM products p GROUP BY p.group_associated", nativeQuery = true)
    List<Object> fetchGroupProducts();
}
