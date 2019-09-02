package com.maaticit.timesheet.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class TimesheetFile {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int fileId;
	
	private String filename;
	private byte[] file;
	
	@ManyToOne
	private Employee employee;

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	
	
	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] bs) {
		this.file = bs;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
	
	

}
