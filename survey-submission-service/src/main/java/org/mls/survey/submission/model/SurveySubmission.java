package org.mls.survey.submission.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "survey_submission")
public class SurveySubmission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long surveyId;
	private String surveyName;
	private Long questionId;
	private String question;

	private String answers;
	// private List<Map<String, String>> answers = new ArrayList<>();

	private String submittedBy;
	private LocalDateTime submittedAt = LocalDateTime.now();

	public SurveySubmission(Long surveyId, String surveyName, Long questionId, String question, String answers,
			String submittedBy) {
		this.questionId = questionId;
		this.question = question;
		this.answers = answers;
		this.submittedBy = submittedBy;
		this.surveyId = surveyId;
		this.surveyName = surveyName;
	}
	
	public SurveySubmission() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getAnswers() {
		return answers;
	}

	public void setAnswers(String answers) {
		this.answers = answers;
	}

	public String getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}

	public LocalDateTime getSubmittedAt() {
		return submittedAt;
	}

	public void setSubmittedAt(LocalDateTime submittedAt) {
		this.submittedAt = submittedAt;
	}

}
