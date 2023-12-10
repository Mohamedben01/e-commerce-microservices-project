package com.ben.billingservice.controller;

import com.ben.billingservice.entity.ProductItem;
import com.ben.billingservice.service.ProductItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/productItem/")
@RequiredArgsConstructor
public class ProductItemController {

	private final ProductItemService productItemService;

	@GetMapping("/add")
	public ResponseEntity<ProductItem> addProductItem(@RequestBody ProductItem productItem) {
		return ResponseEntity.ok().body(productItemService.saveProductItem(productItem));
	}
}
