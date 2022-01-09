package com.University.exception;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.University.UniversityApplication;

public class ErrorDetails {
	private static final Logger logger = LoggerFactory.getLogger(UniversityApplication.class);
	private Date timestamp;
	private String status;
	private String message;
	private String details;

	public ErrorDetails(Date timestamp, String status, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getStatus() {
		logger.error("status");
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		logger.error("message");
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		logger.error("details");
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
