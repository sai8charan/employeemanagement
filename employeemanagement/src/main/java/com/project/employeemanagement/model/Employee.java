package com.project.employeemanagement.model;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	private int employeeId;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotEmpty(message = "Email cannot be empty")
	@Email(message = "Invalid email")
	private String email;
	private String phoneNumber;
	private Date doj;
	private double salary;
	private double annualSalary;
	private double cessAmount;
	private double taxAmount;
}           		
