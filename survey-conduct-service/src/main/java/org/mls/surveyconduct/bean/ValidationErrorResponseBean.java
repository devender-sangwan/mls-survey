package org.mls.surveyconduct.bean;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorResponseBean {

	public ValidationErrorResponseBean() {

	}

	private List<ViolationBean> violations = new ArrayList<>();

	public List<ViolationBean> getViolations() {
		return violations;
	}

	public void setViolations(List<ViolationBean> violations) {
		this.violations = violations;
	}

	
}
