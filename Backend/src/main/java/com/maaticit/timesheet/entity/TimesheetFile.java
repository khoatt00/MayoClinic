package com.maaticit.timesheet.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TimesheetFile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fileId;

	private String filePath;
	private String file;

	@ManyToOne
	private Employee employee;

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String modifiedFileName) {
		this.file = modifiedFileName;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "TimesheetFile [fileId=" + fileId + ", filePath=" + filePath + ", file=" + file + ", employee="
				+ employee + "]";
	}

	
	
	

}