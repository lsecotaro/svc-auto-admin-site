package com.devsupernova.autoadminsite.restservice.product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
    Product findByCategoryId(String categoryId);
}
