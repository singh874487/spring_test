package com.arjun.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Cloud1Sec6EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cloud1Sec6EurekaServerApplication.class, args);
	}

}
