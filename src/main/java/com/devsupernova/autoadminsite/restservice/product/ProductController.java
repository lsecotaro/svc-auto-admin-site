package com.devsupernova.autoadminsite.restservice.product;

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

	@GetMapping("/{category}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Product> products(@PathVariable("category") String category) {
		return ResponseEntity.ok()
				.headers(responseHeaders)
				.body(service.getProductsByCategory(category));
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
}
