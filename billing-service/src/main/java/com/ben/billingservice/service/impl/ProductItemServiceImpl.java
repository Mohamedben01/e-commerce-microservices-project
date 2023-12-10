package com.ben.billingservice.service.impl;

import com.ben.billingservice.entity.ProductItem;
import com.ben.billingservice.repository.ProductItemRepository;
import com.ben.billingservice.service.ProductItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductItemServiceImpl implements ProductItemService {
	private final ProductItemRepository productItemRepository;
	@Override
	public List<ProductItem> productItemByBillId(Long billId) {
		return productItemRepository.findByBillId(billId);
	}

	@Override
	public ProductItem saveProductItem(ProductItem productItem) {
		return productItemRepository.save(productItem);
	}
}
