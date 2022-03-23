package com.brightspeed.service;

import com.brightspeed.model.Product;

public interface ProductService {

	/**
	 * @param productId
	 * @return
	 */
	public Product getProduct(String productId);
	
	/**
	 * @param product
	 * @return
	 */
	public boolean addProduct(Product product);
}
