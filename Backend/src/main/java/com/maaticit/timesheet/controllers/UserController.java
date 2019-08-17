package com.maaticit.timesheet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maaticit.timesheet.entity.Employee;
import com.maaticit.timesheet.service.EmployeeService;



@RestController
@RequestMapping("/employee")
public class UserController {
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/add")
	public void employeeAdd(@RequestBody List<Employee> employee) {
		employeeService.addEmployee(employee);
		
	}


	
}
