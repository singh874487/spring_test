package com.arjun.springboot;

import static org.junit.Assert.*;
 
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.arjun.springboot.core.service.PaymentServiceImpl;
@SpringBootTest
class BootSec4SpringBootCoreApplicationTests {
 

	@Autowired
	private PaymentServiceImpl service;

	@Test
	public void testDependencyInjection() {
		assertNotNull(service.getDao());
	}

}
