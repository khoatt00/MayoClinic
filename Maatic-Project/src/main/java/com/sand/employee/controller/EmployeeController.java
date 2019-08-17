package com.sand.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sand.employee.model.Employee;
import com.sand.employee.model.Login;
import com.sand.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	Login login;
	
	@GetMapping("/login")
	public Employee employeeLogin(Login login) {
//		System.out.println(userName);
//		login.setUserName(userName);
//		login.setPassword(password);
		return employeeService.validateEmployee(login);
		
	}
	@PostMapping("/add")
	public void employeeAdd(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
	}
	
	
	
	
	

}
