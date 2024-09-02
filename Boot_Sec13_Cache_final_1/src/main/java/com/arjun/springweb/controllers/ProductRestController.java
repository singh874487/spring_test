package com.arjun.springweb.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController; 

import com.arjun.springweb.entities.Product;
import com.arjun.springweb.repos.ProductRepository;

@RestController
public class ProductRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductRestController.class);

	@Autowired
	private ProductRepository repository;

	@RequestMapping(value = "/products/", method = RequestMethod.GET)
	public List<Product> getProduct() {

		return repository.findAll();
	}

	@Cacheable("product-cache")
	@Transactional(readOnly = true)
	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable("id") int id) {
		LOGGER.info("finding product by Id: "+id);
		return repository.findById(id).get();
	}

	@RequestMapping(value = "/products/", method = RequestMethod.POST)
	public Product createProduct(@RequestBody Product product) {
		return repository.save(product);
	}

	@RequestMapping(value = "/products/", method = RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product) {
		return repository.save(product);
	}

	@CacheEvict("product-cache")
	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable("id") int id) {
		repository.deleteById(id);
	}

}
