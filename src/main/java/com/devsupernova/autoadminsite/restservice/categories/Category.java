package com.devsupernova.autoadminsite.restservice.categories;

import com.devsupernova.autoadminsite.restservice.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category {
    @Id
    private String id;
    private String name;
    private boolean active;

    @ManyToMany(mappedBy = "categories") //(mappedBy = "category")
    @JsonIgnore
    private Set<Product> products;
}
