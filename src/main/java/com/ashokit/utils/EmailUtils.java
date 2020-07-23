package com.ashokit.utils;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtils {
	@Autowired
	private JavaMailSender javaMailSender;
	
	public boolean sendMessage(String to, String subject, String body) {
		try {
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setTo(to);
			msg.setSubject(subject);
			msg.setText(body);
			javaMailSender.send(msg);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;	  
	}
	
	public boolean sendMailNew(String to, String subject, String body) {
		try {
			MimeMessage msg = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body);
			helper.setText(body, true);
			javaMailSender.send(msg);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

}
