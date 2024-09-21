package com.codingshuttle.project.uber.uberApp;

import com.codingshuttle.project.uber.uberApp.services.EmailSenderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UberAppApplicationTests {

	@Autowired
	private EmailSenderService emailSenderService;

//	@Test
	void contextLoads() {
		emailSenderService.sendEmail("toxovo5105@ploncy.com",
				"This is the Testing Email",
				"Body of my email.");
	}

//	@Test
	void sendBulkEmail(){

		String[] emails = {"hshemant25@gmail.com",
				"hshemant001@gmail.com",
				"garysauls91@gmail.com"};

		emailSenderService.sendBulkEmail(emails,
				"BULK: This is the Testing Email",
				"BULK: Body of my email.");
	}

}
