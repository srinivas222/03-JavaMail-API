package com.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ashokit.utils.EmailUtils;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		EmailUtils emailUtils = ctx.getBean(EmailUtils.class);
		String to = "srinivas222a@gmail.com"; 
		String subject = "Unlock to account";
		String body = "This mail is sent from SpringBoot Application";
		boolean isSend = emailUtils.sendMailNew(to, subject, body);
		System.out.println("Mail send" + isSend);
	}

}
