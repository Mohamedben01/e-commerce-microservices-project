package com.ben.billingservice.service;

import com.ben.billingservice.entity.ProductItem;

import java.util.List;

public interface ProductItemService {
	List<ProductItem> productItemByBillId(Long billId);
	ProductItem saveProductItem(ProductItem productItem);
}
