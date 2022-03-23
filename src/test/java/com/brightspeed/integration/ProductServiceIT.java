package com.brightspeed.integration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.anyOf;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.brightspeed.model.Product;

public class ProductServiceIT extends BaseIntegrationTest {

	private String uri = "/product";

	@Test
	public void createProductSuccess() {
		Product product = new Product();
		product.setId("123");
		product.setName("seed");
		
		Map<String, String> headers = new HashMap<>();
		
		givenBaseSpec()
		.headers(headers)
		.body(product)
		.when()
			.post(uri)
			.then()
				.statusCode(anyOf(is(201) ,is(400), is(404)));
	}
	
	@Test
	public void createProductFailure() {
		Product product = new Product();
		product.setId("123");
				
		givenBaseSpec()
		.body(product)
		.when()
			.post(uri)
			.then()
			.statusCode(anyOf(is(201) ,is(400), is(404)));
		
		givenBaseSpec()
		.body("")
		.when()
			.post(uri)
			.then()
			.statusCode(anyOf(is(201) ,is(400), is(404)));
	}
	
	@Test
	public void getProduct() {
		
		Product product = new Product();
		product.setId("123");
		product.setName("seed");
		
		givenBaseSpec()
		.body(product)
		.when()
			.post(uri)
			.then()
			.statusCode(anyOf(is(201) ,is(400), is(404)));
		
		givenBaseSpec()
		.when().get(uri+"/123")
		.then().statusCode(anyOf(is(201) ,is(400), is(404)));
	}
}
