package com.ben.billingservice.controller;

import com.ben.billingservice.client.CustomerServiceClient;
import com.ben.billingservice.client.InventoryServiceClient;
import com.ben.billingservice.entity.Bill;
import com.ben.billingservice.service.BillService;
import com.ben.billingservice.service.ProductItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bills/")
@RequiredArgsConstructor
public class BillController {
	private final BillService billService;
	@GetMapping("/full/{id}")
	public ResponseEntity<Bill> getBill(@PathVariable(name = "id") Long billId) {
		return ResponseEntity.ok().body(billService.getBillById(billId));
	}
	@PostMapping("/add")
	public ResponseEntity<Bill> addBill(@RequestBody Bill bill){
		return ResponseEntity.ok().body(billService.saveBill(bill));
	}
}
