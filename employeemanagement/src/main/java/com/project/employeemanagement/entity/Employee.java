package com.project.employeemanagement.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date doj;
	private double salary;

	public Employee(com.project.employeemanagement.model.Employee employee) {
		this.firstName = employee.getFirstName();
		this.lastName = employee.getLastName();
		this.email = employee.getEmail();
		this.phoneNumber = employee.getPhoneNumber();
		this.doj = employee.getDoj();
		this.salary = employee.getSalary();
	}
}
