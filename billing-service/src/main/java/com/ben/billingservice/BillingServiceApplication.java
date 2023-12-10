package com.ben.billingservice;

import com.ben.billingservice.client.CustomerServiceClient;
import com.ben.billingservice.client.InventoryServiceClient;
import com.ben.billingservice.entity.Bill;
import com.ben.billingservice.entity.Customer;
import com.ben.billingservice.entity.ProductItem;
import com.ben.billingservice.repository.BillRepository;
import com.ben.billingservice.service.BillService;
import com.ben.billingservice.service.ProductItemService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}


	/*@Bean
	CommandLineRunner start(BillService billService, ProductItemService productItemService,
							InventoryServiceClient inventoryServiceClient, CustomerServiceClient customerServiceClient) {
		return args -> {
			Bill bill = new Bill();
			bill.setBillingDate(new Date());
			Customer customer = customerServiceClient.findCustomerById(1L);
			bill.setCustomerId(customer.getId());
			billService.saveBill(bill);

			inventoryServiceClient.findALlProducts().stream().forEach(p -> {
				productItemService.saveProduct(
						ProductItem.builder()
								.bill(bill)
								.productId(p.getId())
								.price(p.getPrice())
								.quantity(1+Math.random()*1000)
								.build()
				);
			});
		};
	}*/

}
