package com.arjun.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Cloud1Sec5ProductMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cloud1Sec5ProductMicroServiceApplication.class, args);
	}

}
