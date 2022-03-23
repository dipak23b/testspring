package com.brightspeed.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.brightspeed.helper.ProductHelper;
import com.brightspeed.model.Product;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceTest {

	@InjectMocks
	private ProductServiceImpl productService;
	
	@Mock
	private ProductHelper productHelper;
	
	@Test
	public void testGetProduct() {
		Product product = Mockito.mock(Product.class);
		when(product.getId()).thenReturn("p123");
		when(product.getName()).thenReturn("product1");
		when(productHelper.getProduct(Mockito.any())).thenReturn(product);
		Product responseProduct = productService.getProduct(Mockito.anyString());
		assertEquals("p123", responseProduct.getId());
		assertEquals("product1", responseProduct.getName());
		
		
	}

	@Test
	public void testAddProduct() {
		Product product = Mockito.mock(Product.class);
		when(product.getId()).thenReturn("p123");
		when(product.getName()).thenReturn("product1");
		when(productHelper.addProduct(Mockito.any())).thenReturn(true);
		assertTrue(productService.addProduct(product));
	}

}
