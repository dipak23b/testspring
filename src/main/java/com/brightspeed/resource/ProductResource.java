package com.brightspeed.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.brightspeed.model.Product;

@Api("Product")
@Path("/product")
@Produces({MediaType.APPLICATION_JSON})
public interface ProductResource {

	@GET
	@Path("/{productId}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@ApiOperation(
			value = "Product Resource",
			notes = "Returns the product information for a give product id.",
			response = Product.class
			)
	@ApiResponses(
			value = {
					@ApiResponse(code=200, message = "Ok"),
					@ApiResponse(code=404, message = "Not Found")					
			}
			)
	public Response getProduct(
			@ApiParam(value = "Product Id to retrieve" ,required = true)
			@PathParam("productId") String productId);
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@ApiOperation(
			value = "Add Product",
			notes = "Add Product to inventory."
			)
	@ApiResponses(
			value = {
					@ApiResponse(code=201, message = "Product Created."),
					@ApiResponse(code=409, message = "Constraint violated")					
			}
			)
	public Response addProduct(
			@ApiParam(value ="Product to be created." , required = true)	
			Product product);
}
