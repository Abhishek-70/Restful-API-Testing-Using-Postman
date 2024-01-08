package com.web_App_2.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

//Handover this Simple class to the Spring to manage  the bean creation by Spring IOC using service/@Component
@Component
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail(String to,String subject,String message) {
		SimpleMailMessage sm=new SimpleMailMessage();
		sm.setTo(to);
		sm.setSubject(subject);
		sm.setText(message);
		
		 javaMailSender.send(sm);
		
	}
}
