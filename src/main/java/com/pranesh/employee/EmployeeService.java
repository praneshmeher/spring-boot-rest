package com.pranesh.employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	List<Employee> list = new ArrayList<>(Arrays.asList(
				new Employee(1,"Pranesh", 1000),
				new Employee(2, "Ravindra", 20000),
				new Employee(3, "Akshay", 30000)
			));
	
	public Employee getEmployee(String id) {
		return employeeRepository.findById(Integer.valueOf(id)).orElse(null);
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Employee addEmployee(Employee e) {
		return employeeRepository.save(e);
	}
	
	@Transactional
	public Employee updateEmployee(Employee e) {
		employeeRepository.save(e);
		throw new RuntimeException();
	}
	
}
