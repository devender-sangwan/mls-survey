package org.mls.surveyconduct.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "option")
public class Option {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String label;

	private LocalDateTime createdAt = LocalDateTime.now();

	private Boolean isDeleted = false;

	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question;

	public Option() {
	}

	public Option(String optionLabel) {
		this.label = optionLabel;
	}

	public Option(Long id, String optionLabel) {
		this.label = optionLabel;
		this.id = id;
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

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}
