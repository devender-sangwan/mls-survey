package org.mls.surveyconduct.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class QuestionDTO implements Comparable<Long> {

	@NotNull(message = "Question Id must not be null")
	@Min(value = 1, message = "Question Id must be greater than zero")
	private Long questionId;

	@NotBlank(message = "Question must not be blank")
	private String question;

	private @Valid Set<OptionDTO> questionOptions = new LinkedHashSet<>(0);

	public QuestionDTO() {

	}

	public QuestionDTO(String question) {
		this.question = question;
	}

	public QuestionDTO(Long questionId, String question, Set<OptionDTO> optionsDto) {
		this.questionId = questionId;
		this.question = question;
		this.getQuestionOptions().addAll(optionsDto);
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

	public Set<OptionDTO> getQuestionOptions() {
		return questionOptions;
	}

	public void setQuestionOptions(Set<OptionDTO> questionOptions) {
		this.questionOptions = questionOptions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuestionDTO other = (QuestionDTO) obj;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		return true;
	}

	@Override
	public int compareTo(Long questionId) {
		return this.questionId.compareTo(questionId);
	}

}
