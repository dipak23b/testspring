package com.brightspeed.resource;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.brightspeed.model.Product;
import com.brightspeed.service.ProductService;

@Controller
public class ProductResouceImpl implements ProductResource {

	private static final String SUCCESS = "success";
	private static final String RESULT = "result";
	@Autowired
	private ProductService productService;
	
	@Override
	public Response getProduct(String productId) {
		Product product = productService.getProduct(productId);
		
		return Response.ok(product).build();
	}

	@Override
	public Response addProduct(Product product) {
		productService.addProduct(product);
		Map<String,String> result = new HashMap<>();
		result.put(RESULT, SUCCESS);	
		return Response.status(Status.CREATED).entity(result).build();
	}

}
