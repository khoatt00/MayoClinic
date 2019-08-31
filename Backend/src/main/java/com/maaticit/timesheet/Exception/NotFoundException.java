package com.maaticit.timesheet.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class NotFoundException extends MaaticTimesheetException {
	public NotFoundException(String message) {
		super(message);
	}

	public NotFoundException(String msg, Throwable err) {
		super(msg, err);
	}

	public NotFoundException(Throwable err) {
		super(err);
	}
}
