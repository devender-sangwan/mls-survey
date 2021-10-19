package org.mls.surveyconduct.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

public class AddQuestionDTO implements Comparable<Long> {

	@NotBlank(message = "Question must not be blank")
	private String question;

	private @Valid Set<AddOptionDTO> questionOptions = new LinkedHashSet<>(0);

	public AddQuestionDTO() {

	}

	public AddQuestionDTO(String question) {
		this.question = question;
	}

	public AddQuestionDTO(String question, Set<AddOptionDTO> optionsDto) {
		this.question = question;
		this.getQuestionOptions().addAll(optionsDto);
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Set<AddOptionDTO> getQuestionOptions() {
		return questionOptions;
	}

	public void setQuestionOptions(Set<AddOptionDTO> questionOptions) {
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
		AddQuestionDTO other = (AddQuestionDTO) obj;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		return true;
	}

	@Override
	public int compareTo(Long questionId) {
		return this.question.compareTo(question);
	}

}
