package com.example.demo.exceptionhandler;

public class ErrorResponse {
    private String message;
    private String error;
    private String resourceName;

    public ErrorResponse(String message, String error, String resourceName) {
        this.message = message;
        this.error = error;
        this.resourceName = resourceName;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

    // Getters and setters
}

