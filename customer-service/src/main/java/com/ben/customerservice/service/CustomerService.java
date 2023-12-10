package com.ben.customerservice.service;

import com.ben.customerservice.entity.Customer;

import java.util.List;

public interface CustomerService {

	Customer saveCustomer(Customer customer);
	List<Customer> allCustomer();
	Customer getCustomerById(Long id);
	Customer getCustomerByEmail(String email);
	Customer updateCustomer(Customer customer, Long id);
	Long deleteCustomer(Long id);
	List<Customer> searchCustomers(String keyword);

}
