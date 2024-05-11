package com.learnspringbootmicroservice.productservice;

import io.restassured.RestAssured;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {


	@ServiceConnection
 	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:latest");

	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setUp() {
		RestAssured.baseURI = "http://localhost:";
		RestAssured.port = port;
	}

	static {
		mongoDBContainer.start();
	}

	@Test
	void shoudCreateProduct() {
		String requestBody = """
				{
					"productName":"iPhone15"
					"productDescription":"iPhone 15 is smart phone for a apple"
					"productPrice": 1000
				}
				""";

		RestAssured.given()
				.body(requestBody)
				.contentType("application/json")
				.when()
				.post("/api/product")
				.then()
				.statusCode(201)
				.body("productId", Matchers.notNullValue())
				.body("productName", Matchers.equalTo("iPhone15"))
				.body("productDescription", Matchers.equalTo("iPhone 15 is smart phone"))
				.body("productPrice", Matchers.equalTo(1000));

	}

}
