package com.arjun.springweb.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arjun.springweb.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}

