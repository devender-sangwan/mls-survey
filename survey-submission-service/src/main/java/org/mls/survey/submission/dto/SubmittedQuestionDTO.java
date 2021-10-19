package org.mls.survey.submission.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SubmittedQuestionDTO {

	@NotNull
	private Long questionId;
	@NotBlank
	private String question;
	@NotEmpty
	private List<Map<String, String>> answers = new ArrayList<>();

	public SubmittedQuestionDTO() {
	}

	public SubmittedQuestionDTO(Long surveyId, String surveyName, Long questionId, String question,
			List<Map<String, String>> answers) {
		this.questionId = questionId;
		this.question = question;
		this.answers = answers;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Map<String, String>> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Map<String, String>> answers) {
		this.answers = answers;
	}

}
