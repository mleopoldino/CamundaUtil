package br.com.interfile.interflow.core.exception;

import java.io.Serializable;

import com.google.common.base.Throwables;

public class BpmException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;

	private String errorCode;
	
	private String friendlyStackTrace;

	public BpmException(String message, String errorCode) {
		super(message);
		this.setErrorCode(errorCode);
		this.setFriendlyStackTrace(Throwables.getStackTraceAsString(this));
	}

	public BpmException(Exception e) {
		super(e);
	}
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	public String getFriendlyStackTrace() {
		return friendlyStackTrace;
	}

	public void setFriendlyStackTrace(String friendlyStackTrace) {
		this.friendlyStackTrace = friendlyStackTrace;
	}
	
}
