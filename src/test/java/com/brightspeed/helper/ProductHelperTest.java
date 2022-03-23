package com.brightspeed.helper;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import com.brightspeed.model.Product;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductHelperTest {

	@InjectMocks
	private ProductHelper productHelper;
	
	@Mock
	private Map<String, Product> productRepo;
	
	@Test
	public void testGetProduct() {
		Product product = Mockito.mock(Product.class);
		when(productRepo.get(Mockito.any())).thenReturn(product);
		Product responseProduct = productHelper.getProduct("p123");
		assertEquals(product, responseProduct);
		
	}

	@Test
	public void testAddProduct() {
		Product product = Mockito.mock(Product.class);
		assertTrue(productHelper.addProduct(product));
	}

}
