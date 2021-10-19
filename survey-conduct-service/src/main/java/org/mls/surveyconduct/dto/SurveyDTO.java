package org.mls.surveyconduct.dto;

import javax.validation.constraints.NotBlank;
public class SurveyDTO {

	private Long surveyId;
	
	@NotBlank(message = "Survey name must not be blank")
	private String name;

	public SurveyDTO() {
	}

	public SurveyDTO(String name) {
		this.name = name;
	}

	public SurveyDTO(Long surveyId, String name) {
		this.name = name;
		this.surveyId = surveyId;
	}

	public Long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
