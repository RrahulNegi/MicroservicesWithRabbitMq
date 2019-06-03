package com.employee_managment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee_managment.bean.EmployeeBean;
import com.employee_managment.entity.Employee;
import com.employee_managment.repository.EmployeeRepository;
import com.employee_managment.service.RabbitMqSender;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	RabbitMqSender rabbitMQSender;


	@PostMapping(value="/saveEmployee")
	public String employeeSave(@RequestBody EmployeeBean employee){
		System.out.println("employee=="+employee.getName());
		Employee employeeEntity= new Employee(employee.getName(),employee.getDepartment(),employee.getEmail());
		employeeRepository.save(employeeEntity);
		rabbitMQSender.send(employee);
		return "employee save successfully";
	}
	@GetMapping(value="/getEmployee")
	public String getEmployee(){
		return "employee get suceesfully";
	}
}
