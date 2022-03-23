package com.brightspeed.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.brightspeed.resource.ProductResouceImpl;

@Configuration
@ApplicationPath("/productms")
public class JerseyConfiguration extends ResourceConfig {

	@Autowired
	public JerseyConfiguration() {
		register(ProductResouceImpl.class);
		this.property(ServletProperties.FILTER_FORWARD_ON_404, true);
	}
}
