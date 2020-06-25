package com.example.restservice;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Product {
	private final long id;
	private final String code;
	private final String title;
	private final String description;
	private final String image;
	private final double price;
}
