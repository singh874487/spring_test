package com.arjun.springweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class BootSec6ProductRestApi2Application {

	public static void main(String[] args) {
		SpringApplication.run(BootSec6ProductRestApi2Application.class, args);
	}

}
