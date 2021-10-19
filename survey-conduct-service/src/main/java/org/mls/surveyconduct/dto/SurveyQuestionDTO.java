package org.mls.surveyconduct.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class SurveyQuestionDTO {

	@NotNull(message = "Survey Id must not be null")
	@Min(value = 1, message = "Survey Id must be greater than zero")
	private Long surveyId;

	private @Valid Set<QuestionDTO> questions = new LinkedHashSet<>(0);

	public SurveyQuestionDTO() {
		
	}
	public SurveyQuestionDTO(Long surveyId, Set<QuestionDTO> questions) {
		this.surveyId = surveyId;
		this.questions = questions;
	}

	public Long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}

	public Set<QuestionDTO> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<QuestionDTO> questions) {
		this.questions = questions;
	}

}
