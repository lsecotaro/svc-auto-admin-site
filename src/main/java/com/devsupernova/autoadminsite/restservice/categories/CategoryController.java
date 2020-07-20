package com.devsupernova.autoadminsite.restservice.categories;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService service;
    private final HttpHeaders responseHeaders;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Category>> categories() {
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(service.getAll());
    }

    @GetMapping("/actives")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Category>> activeCategories() {
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(service.getAllActive());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Category> create(@RequestBody Category category){
        return ResponseEntity.created(URI.create("/"))
                .headers(responseHeaders)
                .body(service.add(category));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Category> update(@RequestBody Category category){
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(service.update(category));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .build();
    }
}
