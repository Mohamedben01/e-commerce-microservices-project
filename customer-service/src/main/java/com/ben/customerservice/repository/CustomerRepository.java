package com.ben.customerservice.repository;

import com.ben.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Customer findCustomerByEmail(String email);
	Long deleteCustomerById(Long id);
	@Query("""
              SELECT c FROM Customer c WHERE c.firstName like :keyword
              OR c.lastName like :keyword OR c.email like :keyword
           """)
	List<Customer> searchCustomers(@Param("keyword") String keyword);
}
