package org.mls.surveyconduct.bean;

public class ViolationBean {

	public ViolationBean() {

	}

	public ViolationBean(String fieldName, String message) {
		this.fieldName = fieldName;
		this.message = message;
	}

	private String fieldName;

	private String message;

	public String getFieldName() {
		return fieldName;
	}

	public String getMessage() {
		return message;
	}

}
