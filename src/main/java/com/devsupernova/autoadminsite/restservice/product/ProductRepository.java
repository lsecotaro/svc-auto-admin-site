package com.devsupernova.autoadminsite.restservice.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByCategories_Name(String categoryName);
}
