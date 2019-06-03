package com.mail.sender.application.controller.mail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	public void mailSend(Email eParams) throws MessagingException {

		sendMail(eParams);

	}

	public void sendMail(Email eParams) throws MessagingException {
		boolean isHtml = true;
		MimeMessage message = mailSender.createMimeMessage();
		// MimeMessageHelper helper= new MimeMessageHelper(message, true,
		// "UTF-8");
		message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(eParams.getTo().toArray(new String[eParams.getTo().size()])[0]));
		message.setFrom(eParams.getFrom());
		message.setSubject(eParams.getSubject());
	
	
				System.out
				.println("" + eParams.getTo() + "     " + eParams.getTo().toArray(new String[eParams.getTo().size()]));
		System.out.println(eParams.getFrom());
		System.out.println(eParams.getSubject());
		System.out.println(eParams.getMessage());
		mailSender.send(message);
	}
	
	

}
