package com.ben.inventoryservice.service.impl;

import com.ben.inventoryservice.entity.Product;
import com.ben.inventoryservice.exception.ProductNotFoundException;
import com.ben.inventoryservice.repository.ProductRepository;
import com.ben.inventoryservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> allProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product findProductById(Long id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("Not found product with This  id: "+id));
	}
}
