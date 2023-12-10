package com.ben.inventoryservice.controller;

import com.ben.inventoryservice.entity.Product;
import com.ben.inventoryservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/inventories/")
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;

	@PostMapping("/add")
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		return ResponseEntity.ok().body(productService.saveProduct(product));
	}
	@GetMapping("/all")
	public ResponseEntity<List<Product>> allProducts(){
		return ResponseEntity.ok().body(productService.allProducts());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){
		return ResponseEntity.ok().body(productService.findProductById(id));
	}
}
