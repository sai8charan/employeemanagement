package com.project.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.employeemanagement.model.Employee;
import com.project.employeemanagement.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employee")
	public ResponseEntity<?> saveEmployeeDetails(@RequestBody Employee employee){
		log.info("Entry :: EmployeeController --> saveEmployeeDetails method");
		employeeService.saveEmployee(employee);
		return ResponseEntity.ok("employee details saved successfully");
	}
	
	@GetMapping("/employee")
	public ResponseEntity<?> getEmployeeDetails(){
		log.info("Entry :: EmployeeController --> saveEmployeeDetails method");
		return ResponseEntity.ok(employeeService.getEmployee());
	}
	
	@GetMapping("/employee/{id}/taxdetails")
	public ResponseEntity<?> getEmployeeTaxDetails(@PathVariable int id) throws Exception{
		log.info("Entry :: EmployeeController --> getEmployeeTaxDetails method");
		return new ResponseEntity<>(employeeService.getEmployeeTaxDetails(id), HttpStatus.OK);
	}
	
}
