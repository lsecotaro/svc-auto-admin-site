package com.example.restservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@GetMapping("/product")
	public ResponseEntity<List<Product>> products() {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-Control-Allow-Origin", "*");

		return ResponseEntity.ok()
				.headers(responseHeaders)
				.body(mockProducts());
	}

	private List<Product> mockProducts() {
		List<Product> list = new ArrayList();
		for (int i = 0; i < 15; i++) {
			list.add(Product.builder()
					.code(String.format("%d",i))
					.description(String.format("Description %d",i))
					.price(33*i)
					.title(String.format("Title %d",i))
					.build());
		}
		return list;
	}

	@GetMapping("/menu")
	public ResponseEntity<CustomMenu> menu() {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-Control-Allow-Origin", "*");

		return ResponseEntity.ok()
				.headers(responseHeaders)
				.body(mockMenu());
	}

	private CustomMenu mockMenu() {
		List<MyCustomMenuItem> items = new ArrayList<>();
		items.add(MyCustomMenuItem.builder()
				.name("Productos")
				.build());
		items.add(MyCustomMenuItem.builder()
				.name("Nosotros")
				.build());
		items.add(MyCustomMenuItem.builder()
				.name("Contactos")
				.build());
		return CustomMenu.builder()
				.items(items)
				.build();
	}

}
