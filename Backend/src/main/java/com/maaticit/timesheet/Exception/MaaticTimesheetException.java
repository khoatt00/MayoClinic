package com.maaticit.timesheet.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
public class MaaticTimesheetException extends Exception {
		
		public MaaticTimesheetException(String message) {
			super(message);
		}

		public MaaticTimesheetException(String msg, Throwable err) {
			super(msg, err);
		}

		public MaaticTimesheetException(Throwable err) {
			super(err);
		}
}

