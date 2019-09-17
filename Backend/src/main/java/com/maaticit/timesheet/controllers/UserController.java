package com.maaticit.timesheet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 

import com.maaticit.timesheet.Exception.MaaticTimesheetException;
import com.maaticit.timesheet.dto.EmployeeDto;
import com.maaticit.timesheet.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	EmployeeService employeeService;


	@PostMapping("/user")
	public EmployeeDto addEmployee(@RequestBody EmployeeDto employeeDto) throws MaaticTimesheetException {
		return employeeService.addEmployee(employeeDto);

	}

	@GetMapping("/user")
	public List<EmployeeDto> getAllEmployee() {
		return employeeService.getAllEmployee();

	}

	@GetMapping("/user/{id}")
	public EmployeeDto getEmployeeById(@PathVariable int id) {
		return employeeService.getEmployeeById(id);
	}
	
	
}
