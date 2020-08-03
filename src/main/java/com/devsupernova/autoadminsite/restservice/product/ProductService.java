package com.devsupernova.autoadminsite.restservice.product;

import com.devsupernova.autoadminsite.restservice.utils.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public List<Product> getAllProducts(){
        return repository.findAll();
    }

    public List<Product> getProductsByCategory(String category){
        return repository.findByCategories_Name(category);
    }

    public Product add(Product product){
        product.setId(IdGenerator.generate());
        return repository.save(product);
    }

    public Product update(Product product){
        return repository.save(product);
    }

    public void delete(String id){
        repository.delete(repository.getOne(id));
    }
}
