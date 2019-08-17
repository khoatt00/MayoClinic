package com.maaticit.timesheet.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.maaticit.timesheet.entity.TestEntity;

@Repository
public class TestRepository {
	List<TestEntity> testEntities = new ArrayList<>();

	public List<TestEntity> getTestEntities() {
		return testEntities;
	}
}
