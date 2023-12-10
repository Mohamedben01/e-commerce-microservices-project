package com.ben.billingservice.client;

import com.ben.billingservice.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("inventory-service")
public interface InventoryServiceClient {
	@GetMapping("/{id}?projection=fullProduct")
	Product findProductById(@PathVariable("id") Long id);
	@GetMapping("/all?projection=fullProduct")
	List<Product> findALlProducts();
}
