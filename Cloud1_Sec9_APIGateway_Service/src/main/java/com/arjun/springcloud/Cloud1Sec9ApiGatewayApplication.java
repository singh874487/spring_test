package com.arjun.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Cloud1Sec9ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cloud1Sec9ApiGatewayApplication.class, args);
	}

}
