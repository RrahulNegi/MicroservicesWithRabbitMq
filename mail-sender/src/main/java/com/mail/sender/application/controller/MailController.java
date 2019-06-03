package com.mail.sender.application.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mail.sender.application.controller.mail.Email;
import com.mail.sender.application.controller.mail.EmailService;
import com.mail.sender.application.controller.mail.SubscriberService;
@RestController
public class MailController {

@Autowired
EmailService mailService;

@Autowired
EmailService emailService;

@Autowired
SubscriberService subscriberService;

@RequestMapping(value="/sendMail", method=RequestMethod.POST)
@ResponseBody
public String sendMail(@RequestBody Email mailDataBean){
	
	try {
		mailService.sendMail(mailDataBean);
	} catch (MessagingException e) {
		e.printStackTrace();
	}

	return "";
}
}
