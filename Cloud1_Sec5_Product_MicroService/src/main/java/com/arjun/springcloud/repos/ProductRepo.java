package com.arjun.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arjun.springcloud.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
