package com.ben.inventoryservice.service;

import com.ben.inventoryservice.entity.Product;

import java.util.List;

public interface ProductService {
	Product saveProduct(Product product);
	List<Product> allProducts();
	Product findProductById(Long id);
}
