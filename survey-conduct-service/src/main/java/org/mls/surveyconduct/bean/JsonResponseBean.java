package org.mls.surveyconduct.bean;

public class JsonResponseBean {

	private String status;

	private int statusCode;

	private String message;

	private Object reason;

	public JsonResponseBean(final int statusCode, final String message) {
		this.message = message;
		this.statusCode = statusCode;
	}

	public JsonResponseBean(final String status, final int statusCode, final String message) {
		this.status = status;
		this.message = message;
		this.statusCode = statusCode;
	}

	public JsonResponseBean(final String status, final int statusCode, final String message, final Object reason) {
		this.status = status;
		this.message = message;
		this.statusCode = statusCode;
		this.reason = reason;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getReason() {
		return reason;
	}

	public void setReason(Object reason) {
		this.reason = reason;
	}
}
