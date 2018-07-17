package com.halfords.partfinder.exception;

public class ATPException extends Exception {
	
	private long elapsedTime;

	public ATPException() {
		super();
	}

	public ATPException(String message) {
		super(message);
	}

	public ATPException(String message, Throwable cause) {
		super(message, cause);
	}

	public ATPException(Throwable cause) {
		super(cause);
	}
	
	public void setElapsedTime(long milliseconds) {
		this.elapsedTime = milliseconds;
	}
	
	public long getElapsedTime() {
		return this.elapsedTime;
	}
}
