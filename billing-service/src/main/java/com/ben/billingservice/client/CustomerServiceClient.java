package com.ben.billingservice.client;

import com.ben.billingservice.entity.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerServiceClient {
	@GetMapping("/{id}?projection=fullCustomer")
	Customer findCustomerById(@PathVariable("id") Long id);
}
