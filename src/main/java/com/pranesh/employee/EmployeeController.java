package com.pranesh.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Response> getEmployee(@PathVariable String id) {
		Response<Employee> response = new Response<>();
		response.setData(this.employeeService.getEmployee(id));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<Response> getAllEmployee() {
		Response<List> response = new Response<>();
		response.setData(this.employeeService.getAllEmployees());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Response> addEmployee(@RequestBody Employee e) {
		Response<Employee> response = new Response<>();
		response.setData(this.employeeService.addEmployee(e));
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/employees")
	public ResponseEntity<Response> updateEmployee(@RequestBody Employee e) {
		Response<Employee> response = new Response<>();
		response.setData(this.employeeService.updateEmployee(e));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/employees/exception")
	public void getEmployeeException() {	
		throw new NullPointerException();
	}
	
}
