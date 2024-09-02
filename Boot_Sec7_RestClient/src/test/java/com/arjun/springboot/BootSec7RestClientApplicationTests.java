package com.arjun.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.arjun.springboot.entities.Product;

@SpringBootTest
class BootSec7RestClientApplicationTests {

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

	@Test
	void testCreateProduct() {

		Product prod = new Product();
		prod.setName("MicroMax");
		prod.setDescription("Its Good");
		prod.setPrice(1000);
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.postForObject(baseUrl, prod, Product.class);
		assertNotNull(product);
		assertNotNull(product.getId());
		assertEquals("MicroMax", product.getName());

	}

	@Test
	void testUpdateProduct() {

		RestTemplate restTemplate = new RestTemplate();

		Product product = restTemplate.getForObject(baseUrl + "1", Product.class);
		product.setPrice(20000);
		product.setName("IPhone");
		restTemplate.put(baseUrl, product, Product.class);
		Product updatedProduct = restTemplate.getForObject(baseUrl + "1", Product.class);

		assertNotNull(updatedProduct.getId());
		assertEquals(20000, updatedProduct.getPrice());
		// assertEquals("Its Good", updatedProduct.getDescription() );
	}

}
