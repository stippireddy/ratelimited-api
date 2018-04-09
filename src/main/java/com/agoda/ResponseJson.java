package com.agoda;

import com.agoda.ResponseJson;

public class ResponseJson {
	private int statusCode;
	private String message;
	private Object results;

	public void setResults(Object results) {
		this.results = results;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResults() {
		return results;
	}

}
