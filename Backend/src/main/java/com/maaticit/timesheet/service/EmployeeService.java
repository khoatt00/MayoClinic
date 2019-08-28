package com.maaticit.timesheet.service;

import java.util.List;

import com.maaticit.timesheet.dto.EmployeeDto;
import com.maaticit.timesheet.entity.Employee;

public interface EmployeeService {

	EmployeeDto addEmployee(EmployeeDto employeeDto);

	List<EmployeeDto> getAllEmployee();

	public EmployeeDto getEmployeeById(int id);
}
