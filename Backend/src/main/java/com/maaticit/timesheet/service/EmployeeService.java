package com.maaticit.timesheet.service;

import java.util.List;

import com.maaticit.timesheet.Exception.InvalidRequestException;
import com.maaticit.timesheet.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto addEmployee(EmployeeDto employeeDto) throws InvalidRequestException;

	List<EmployeeDto> getAllEmployee();


	public EmployeeDto getEmployeeById(int id);


}
