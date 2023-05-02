package com.project.employeemanagement.model;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	private int employeeId;
	private String firstName;
	private String lastName;
	@NotEmpty(message = "Email cannot be empty")
	@Email(message = "Invalid email")
	private String email;
	private String phoneNumber;
	private Date doj;
	private double salary;
}
