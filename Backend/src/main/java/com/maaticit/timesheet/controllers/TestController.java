package com.maaticit.timesheet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maaticit.timesheet.service.TestService;

@RestController
@RequestMapping("/api")
public class TestController {

	@Autowired
	private TestService testService;
	
	@RequestMapping(value="/test",method = RequestMethod.GET)
	public void getTest() {
		testService.getTestEntities();
	}
	
}
