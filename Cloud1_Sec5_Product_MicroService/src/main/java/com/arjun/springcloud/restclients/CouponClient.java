package com.arjun.springcloud.restclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.arjun.springcloud.model.Coupon;

@FeignClient("GATEWAY-SERVICE")
public interface CouponClient {

	@GetMapping(value = "/couponapi/coupons/{code}")
	Coupon getCoupon(@PathVariable("code") String code);

}
