package org.mls.survey.submission.bean;

import java.io.Serializable;

public class SubmittedAnswer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long answerId;
	private String answer;
	private Boolean isChecked = Boolean.FALSE;

	public SubmittedAnswer() {

	}

	public SubmittedAnswer(Long answerId, String answer, Boolean isChecked) {
		this.answerId = answerId;
		this.answer = answer;
		this.isChecked = isChecked;
	}

	public Long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Boolean getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(Boolean isChecked) {
		this.isChecked = isChecked;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
