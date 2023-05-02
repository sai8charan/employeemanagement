package com.project.employeemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.employeemanagement.model.Employee;
import com.project.employeemanagement.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public void saveEmployee(Employee employee) {
		log.info("Entered EmployeeService in saveEmployee method");
		com.project.employeemanagement.entity.Employee emp1 = new com.project.employeemanagement.entity.Employee(employee);
		employeeRepository.save(emp1);
	}
	
	public  List<com.project.employeemanagement.entity.Employee> getEmployee() {
		log.info("Entered EmployeeService in getEmployee method");
		return employeeRepository.findAll();
	}
}
