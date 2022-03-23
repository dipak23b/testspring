package com.brightspeed.integration;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
public abstract class BaseIntegrationTest {

	@Value("${server.servlet.context-path}")
	private String contextPath;
	
	@LocalServerPort
    private int port;
	
	@Before
	public void setUp() throws Exception {
		String baseURI = System.getProperty("BASE_URL");
		System.out.println("baseURI................................... ++" +baseURI);

		if (baseURI == null) {
			baseURI = "http://localhost" + ":" + port;
		}

		RestAssured.baseURI = baseURI + contextPath;
		System.out.println("RestAssured.baseURI................................... ++" +RestAssured.baseURI);
	}
	
	/*
	 * Base spec 
	 */
	protected RequestSpecification givenBaseSpec() {
		Map<String, String> headers = new HashMap<>();
		
		return RestAssured.given()
				.relaxedHTTPSValidation()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.headers(headers);
	}
}
