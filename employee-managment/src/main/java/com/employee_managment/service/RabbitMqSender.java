package com.employee_managment.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.employee_managment.bean.EmployeeBean;

@Service
public class RabbitMqSender {
	@Autowired
	private AmqpTemplate rabbitTemplat;
	
	@Value("${jsa.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${jsa.rabbitmq.routingkey}")
	private String routingkey;	
	
	public void send(EmployeeBean employee) {
		rabbitTemplat.convertAndSend(exchange, routingkey, employee);
		System.out.println("Send msg = " + employee);
	    
	}
}

