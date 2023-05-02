package com.project.employeemanagement.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
	private Optional<com.project.employeemanagement.entity.Employee> employee;

	public void saveEmployee(Employee employee) {
		log.info("Entered EmployeeService in saveEmployee method");
		com.project.employeemanagement.entity.Employee emp1 = new com.project.employeemanagement.entity.Employee(
				employee);
		employeeRepository.save(emp1);
	}

	public List<com.project.employeemanagement.entity.Employee> getEmployee() {
		log.info("Entered EmployeeService in getEmployee method");
		return employeeRepository.findAll();
	}

	public Employee getEmployeeTaxDetails(int id) throws Exception {

		employee = employeeRepository.findById(id);
		Employee employeeModel = new Employee();
		double taxAmount;
		double cessAmount;
		double annualSalary;
		if (employee.isEmpty()) {
			throw new Exception("employee not found");
		}
		com.project.employeemanagement.entity.Employee emp = employee.get();
		if (emp.getDoj().before(new Date(2022, 4, 1))) {
			taxAmount = calculateTax(emp.getSalary() * 12);
			cessAmount = calculateCess(emp.getSalary() * 12);
		} else {
			int month = emp.getDoj().getMonth();
			if (month < 3) {
				month = month + 8;
			}
			month++;
			int days = 30 - emp.getDoj().getDay();
			taxAmount = calculateTax(month * emp.getSalary() + days / 30 * emp.getSalary());
			cessAmount = calculateCess(month * emp.getSalary() + days / 30 * emp.getSalary());

		}
		annualSalary = emp.getSalary() * 12;
		employeeModel.setAnnualSalary(annualSalary);
		employeeModel.setCessAmount(cessAmount);
		employeeModel.setTaxAmount(taxAmount);
		employeeModel.setEmployeeId(emp.getEmployeeId());
		employeeModel.setFirstName(emp.getFirstName());
		employeeModel.setLastName(emp.getLastName());

		return employeeModel;
	}

	private double calculateTax(double salary) {
		double tax = 0;
		if (salary > 250000) {
			tax = (5 * (salary - 250000) / 100);
		}
		if (salary > 500000) {
			tax = tax + (10 * (salary - 500000) / 100);
		}
		if (salary > 1000000) {
			tax = tax + (20 * (salary - 500000) / 100);
		}
		return tax;
	}

	private double calculateCess(double salary) {
		if (salary > 2500000)
			return (salary * 2) / 100;
		return 0;
	}
}
