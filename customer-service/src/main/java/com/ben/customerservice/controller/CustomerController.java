package com.ben.customerservice.controller;

import com.ben.customerservice.entity.Customer;
import com.ben.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers/")
@RequiredArgsConstructor
public class CustomerController {
	private final CustomerService customerService;

	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		return ResponseEntity.ok().body(customerService.saveCustomer(customer));
	}
	@GetMapping("/all")
	public ResponseEntity<List<Customer>> allCustomers(){
		return ResponseEntity.ok().body(customerService.allCustomer());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id){
		return ResponseEntity.ok().body(customerService.getCustomerById(id));
	}
	@GetMapping("/byEmail")
	public ResponseEntity<Customer> getCustomerByEmail(@RequestParam("email") String email){
		return ResponseEntity.ok().body(customerService.getCustomerByEmail(email));
	}
	@GetMapping("/search")
	public ResponseEntity<List<Customer>> searchCustomers(@RequestParam(name = "keyword", defaultValue = "") String keyword){
		return ResponseEntity.ok().body(customerService.searchCustomers(keyword));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Long> deleteCustomer(@PathVariable("id") Long id){
		return ResponseEntity.ok().body(customerService.deleteCustomer(id));
	}

}
