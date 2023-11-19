package com.example.Automaster;

import com.example.Automaster.controllers.AuthController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AutomasterApplicationTests {

	@Autowired
	private AuthController controller;
	@Test
	void contextLoads() {
	}

}
