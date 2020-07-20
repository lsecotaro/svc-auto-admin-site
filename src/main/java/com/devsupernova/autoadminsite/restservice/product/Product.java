package com.devsupernova.autoadminsite.restservice.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
	@Id
	private String id;
	private String code;
	private String title;
	private String description;
	private String image;
	private double price;
	private String categoryId;
}
