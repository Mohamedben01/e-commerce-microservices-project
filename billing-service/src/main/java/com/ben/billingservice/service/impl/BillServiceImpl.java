package com.ben.billingservice.service.impl;

import com.ben.billingservice.client.CustomerServiceClient;
import com.ben.billingservice.client.InventoryServiceClient;
import com.ben.billingservice.entity.Bill;
import com.ben.billingservice.entity.Customer;
import com.ben.billingservice.entity.Product;
import com.ben.billingservice.entity.ProductItem;
import com.ben.billingservice.repository.BillRepository;
import com.ben.billingservice.repository.ProductItemRepository;
import com.ben.billingservice.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillServiceImpl implements BillService {
	private BillRepository billRepository;
	private ProductItemRepository productItemRepository;
	private CustomerServiceClient customerServiceClient;
	private InventoryServiceClient inventoryServiceClient;
	@Override
	public Bill getBillById(Long billId) {
		Bill bill = billRepository.findById(billId).get();

		Customer customer = customerServiceClient.findCustomerById(bill.getCustomerId());
		List<ProductItem> productItems = productItemRepository.findByBillId(billId);
		productItems.stream().forEach(pi -> {
			pi.setProduct(inventoryServiceClient.findProductById(pi.getId()));
		});

		bill.setCustomer(customer);
		bill.setProductItems(productItems);

		return bill;
	}

	@Override
	public Bill saveBill(Bill bill) {
		return billRepository.save(bill);
	}
}
