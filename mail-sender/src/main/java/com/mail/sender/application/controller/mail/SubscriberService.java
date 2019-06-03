package com.mail.sender.application.controller.mail;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mail.sender.application.bean.EmployeeBean;

@Component
public class SubscriberService {
	@Autowired
	EmailService mailService;
	@RabbitListener(queues="${jsa.rabbitmq.queue}")
    public void receivedMessage(EmployeeBean employee) {
        System.out.println("Received Message: " + employee.getName());
        String from;
		List<String> to;
		List<String> cc = null;
		String subject;
		String message;
		boolean isHtml;
		String imagePath;
		from="abc@gmail.com";
		to= new ArrayList<String>();
		to.add(employee.getEmail());
		subject= "User is registerd successfully";
		message= "<p>"+employee.getName()+"</p> is added successfully";
		isHtml=true;
		imagePath="";
		Email mailDataBean = new Email(from, to, cc, subject, message, isHtml, imagePath);
        try {
        	if(employee.getName()!=null){
			mailService.sendMail(mailDataBean);
        	}
		} catch (MessagingException e) {
			e.printStackTrace();
		}
        
    }
}

