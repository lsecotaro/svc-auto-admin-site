package com.devsupernova.autoadminsite.restservice.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public List<Product> getAllProducts(){
        return repository.findAll();
    }

    public Product add(Product product){
        product.setId(UUID.randomUUID().toString());
        return repository.save(product);
    }

    public Product update(Product product){
        return repository.save(product);
    }

    public void delete(String id){
        Product product = repository.getOne(id);
        repository.delete(product);
    }
}
