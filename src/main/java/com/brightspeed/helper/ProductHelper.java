package com.brightspeed.helper;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.brightspeed.model.Product;

@Component
public class ProductHelper {

	private Map<String, Product> productRepo = new ConcurrentHashMap<>();
	
	/**
	 * @param productId
	 * @return
	 */
	public Product getProduct(String productId) {
		return productRepo.get(productId);
	}

	/**
	 * @param product
	 * @return
	 */
	public boolean addProduct(Product product) {
		productRepo.put(product.getId(), product);
		return true;
	}
}
