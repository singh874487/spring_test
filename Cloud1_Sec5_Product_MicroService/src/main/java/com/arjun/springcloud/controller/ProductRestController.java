package com.arjun.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arjun.springcloud.model.Coupon;
import com.arjun.springcloud.model.Product;
import com.arjun.springcloud.repos.ProductRepo;
import com.arjun.springcloud.restclients.CouponClient;

@RestController
@RequestMapping("productapi")
public class ProductRestController {

	@Autowired
	private ProductRepo repo;

	@Autowired
	private CouponClient couponClient;

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public Product create(@RequestBody Product product) {

		Coupon coupon = couponClient.getCoupon(product.getCouponCode());
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return repo.save(product);

	}

}
