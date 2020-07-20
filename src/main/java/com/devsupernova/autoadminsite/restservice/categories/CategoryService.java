package com.devsupernova.autoadminsite.restservice.categories;

import com.devsupernova.autoadminsite.restservice.utils.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;

    public List<Category> getAll(){
        return repository.findAll();
    }

    public List<Category> getAllActive(){
        return repository.findAll().stream()
                .filter(Category::isActive)
                .collect(Collectors.toList());
    }

    public Category add(Category category){
        category.setId(IdGenerator.generate());
        return repository.save(category);
    }

    public Category update(Category category){
        return repository.save(category);
    }

    public void delete(String id){
        repository.delete(repository.getOne(id));
    }
}
