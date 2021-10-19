package org.mls.surveyconduct.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String label;

	private LocalDateTime createdAt = LocalDateTime.now();

	private Boolean isDeleted = false;

	@ManyToOne
	@JoinColumn(name = "survey_id")
	private Survey survey;

	@OneToMany(mappedBy = "question", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Option> options = new HashSet<>(0);

	public Question() {
	}

	public Question(String questionLabel) {
		this.label = questionLabel;
	}

	public Question(Long surveyId, String question, Set<Option> questionOptions) {
		this.label = question;
		Survey survey = new Survey();
		survey.setId(surveyId);
		this.survey = survey;
		this.getOptions().addAll(questionOptions);
	}

	public Question(Long surveyId, String question) {
		this.label = question;
		Survey survey = new Survey();
		survey.setId(surveyId);
		this.survey = survey;
	}

	public Question(Long questionId, Long surveyId, String question) {
		this.id = questionId;
		this.label = question;
		Survey survey = new Survey();
		survey.setId(surveyId);
		this.survey = survey;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public LocalDateTime getCreated_at() {
		return createdAt;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.createdAt = created_at;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Set<Option> getOptions() {
		return options;
	}

	public void setOptions(Set<Option> options) {
		this.options = options;
	}

}
