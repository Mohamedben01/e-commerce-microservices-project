package com.ben.customerservice.service.impl;

import com.ben.customerservice.entity.Customer;
import com.ben.customerservice.exception.CustomerNotFoundException;
import com.ben.customerservice.repository.CustomerRepository;
import com.ben.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository customerRepository;
	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> allCustomer() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(Long id) {
		return customerRepository.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException("Not Found Customer With this id: "+ id));
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		return customerRepository.findCustomerByEmail(email);
	}

	@Override
	public Customer updateCustomer(Customer customer, Long id) {
		return null;
	}

	@Override
	public Long deleteCustomer(Long id) {
		return customerRepository.deleteCustomerById(id);
	}

	@Override
	public List<Customer> searchCustomers(String keyword) {
		return customerRepository.searchCustomers(keyword);
	}
}
