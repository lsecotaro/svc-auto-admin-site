package com.devsupernova.autoadminsite.restservice.product;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.devsupernova.autoadminsite.restservice.CustomMenu;
import com.devsupernova.autoadminsite.restservice.MyCustomMenuItem;
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

@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductController {
	private final ProductService service;
	private final HttpHeaders responseHeaders;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Product>> products() {
		return ResponseEntity.ok()
				.headers(responseHeaders)
				.body(service.getAllProducts());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Product> create(@RequestBody Product product){
		return ResponseEntity.created(URI.create("/"))
				.headers(responseHeaders)
				.body(service.add(product));
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Product> update(@RequestBody Product product){
		return ResponseEntity.ok()
				.headers(responseHeaders)
				.body(service.update(product));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.ok()
				.headers(responseHeaders)
				.build();
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
