package com.arjun.springweb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.arjun.springweb.entities.Product;

@SpringBootTest
class BootSec9RestApiLoggerApplicationTests {
 

	@Value("${productrestapi.services.url}")
	private String baseUrl;

	@Test
	void testGetProduct() {

		System.out.println("URL: " + baseUrl);

		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(baseUrl + "1", Product.class);
		assertNotNull(product);
		assertEquals("IPhone", product.getName());

	}

}
