package com.maaticit.timesheet.test;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.maaticit.timesheet.dto.EmployeeDto;
import com.maaticit.timesheet.entity.Employee;
import com.maaticit.timesheet.repo.EmployeeRepository;
import com.maaticit.timesheet.service.EmployeeService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MaaticTimesheetApplicationTests {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeRepository employeeRepository;

	private EmployeeDto employeeDto;

	private EmployeeDto setEmployeeDto() {
		employeeDto =new EmployeeDto();
		employeeDto.setName("sand");
		employeeDto.setPassword("password");
		employeeDto.setPhone("111-222-3333");
		employeeDto.setUsername("sand");
		return employeeDto;

	}

	private Employee getEmployees() {
		Employee employee =new Employee();
		employee.setId(1);
		employee.setId(1);
		employee.setName("sand");
		employee.setPassword("password");
		employee.setPhone("111-222-3333");
		employee.setUsername("sand");
		return employee;

	}

	@Before
	public void setUp() {
		setEmployeeDto();
	}

	@Test
	public void addEmployeeTest() throws Exception {
		EmployeeDto employeeAdded = employeeService.addEmployee(employeeDto);
		Assert.assertNotNull(employeeAdded);
		assertEquals("failure - name doesn't match", employeeDto.getName(), employeeAdded.getName());
		assertEquals("failure - password doesn't match", employeeDto.getPassword(), employeeAdded.getPassword());
		assertEquals("failure - Phone doesn't match", employeeDto.getPhone(), employeeAdded.getPhone());
		assertEquals("failure - username doesn't match", employeeDto.getUsername(), employeeAdded.getUsername());
	}


}
