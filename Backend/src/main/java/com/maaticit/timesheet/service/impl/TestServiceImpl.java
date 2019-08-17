package com.maaticit.timesheet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maaticit.timesheet.repository.TestRepository;
import com.maaticit.timesheet.service.TestService;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	private TestRepository testRepository;
	
	
	@Override
	public void getTestEntities() {
		// TODO Auto-generated method stub
		testRepository.getTestEntities();
	}

}
