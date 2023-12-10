package com.ben.billingservice.service;

import com.ben.billingservice.entity.Bill;

public interface BillService {
	Bill getBillById(Long billId);

	Bill saveBill(Bill bill);
}
