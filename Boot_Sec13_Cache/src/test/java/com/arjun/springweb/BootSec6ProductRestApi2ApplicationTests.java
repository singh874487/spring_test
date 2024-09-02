package com.arjun.springweb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.arjun.springweb.entities.Product;

@SpringBootTest
class BootSec6ProductRestApi2ApplicationTests {

	@Value("${productrestapi.services.url}")
	private String baseUrl;

	@Test
	void testGetProduct() {

		System.out.println("URL: " + baseUrl);

		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(baseUrl + "22", Product.class);
		assertNotNull(product);
		assertEquals("MicroMax", product.getName());

	}

	@Test
	void testCreateProduct() {

		Product prod = new Product();
		prod.setName("Samsung");
		prod.setDescription("Its Good");
		prod.setPrice(1000);
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.postForObject("http://localhost:8080/productapi/products/", prod, Product.class);
		assertNotNull(product);
		assertNotNull(product.getId());
		assertEquals("Samsung", product.getName());

	}

	@Test
	void testUpdateProduct() {

		RestTemplate restTemplate = new RestTemplate();

		Product product = restTemplate.getForObject("http://localhost:8080/productapi/products/22", Product.class);
		product.setPrice(20000);
		restTemplate.put("http://localhost:8080/productapi/products/", product, Product.class);
		Product updatedProduct = restTemplate.getForObject("http://localhost:8080/productapi/products/22",
				Product.class);

		assertNotNull(updatedProduct.getId());
		assertEquals(20000, updatedProduct.getPrice());
	}

}
