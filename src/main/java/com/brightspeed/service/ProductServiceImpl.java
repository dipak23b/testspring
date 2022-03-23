package com.brightspeed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brightspeed.helper.ProductHelper;
import com.brightspeed.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductHelper productHelper;
	
	@Override
	public Product getProduct(String productId) {
		return productHelper.getProduct(productId);
	}

	@Override
	public boolean addProduct(Product product) {
		return productHelper.addProduct(product);
	}

}
