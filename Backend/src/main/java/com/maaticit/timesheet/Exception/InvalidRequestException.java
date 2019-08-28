package com.maaticit.timesheet.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class InvalidRequestException extends MaaticTimesheetException {
	private static final long serialVersionUID = -7334221839039919903L;

	public InvalidRequestException(String message) {
		super(message);
	}

	public InvalidRequestException(String msg, Throwable err) {
		super(msg, err);
	}

	public InvalidRequestException(Throwable err) {
		super(err);
	}

}