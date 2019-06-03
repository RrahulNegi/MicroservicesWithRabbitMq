package com.employee_managment.repository;

import org.springframework.data.repository.CrudRepository;

import com.employee_managment.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
