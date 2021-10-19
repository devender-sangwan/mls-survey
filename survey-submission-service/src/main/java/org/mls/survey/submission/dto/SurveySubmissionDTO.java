package org.mls.survey.submission.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SurveySubmissionDTO {

	@NotNull
	private Long surveyId;

	@NotBlank
	private String surveyName;

	@NotEmpty
	private @Valid List<SubmittedQuestionDTO> questions = new ArrayList<>();

	@NotBlank
	private String submittedBy;

	public SurveySubmissionDTO() {
	}

	public Long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}

	public String getSurveyName() {
		return surveyName;
	}

	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}

	public List<SubmittedQuestionDTO> getQuestions() {
		return questions;
	}

	public void setQuestions(List<SubmittedQuestionDTO> questions) {
		this.questions = questions;
	}

	public String getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}
}
