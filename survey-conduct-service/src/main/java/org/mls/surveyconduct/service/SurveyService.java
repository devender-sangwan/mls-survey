package org.mls.surveyconduct.service;

import java.util.List;

import org.mls.surveyconduct.dto.AddSurveyQuestionDTO;
import org.mls.surveyconduct.dto.SurveyDTO;
import org.mls.surveyconduct.dto.SurveyQuestionDTO;

public interface SurveyService {

	void createSurvey(SurveyDTO surveyDTO);

	List<SurveyDTO> getAllSurveys();

	SurveyDTO getSurvey(Long surveyId);

	void addQuestions(AddSurveyQuestionDTO addSurveyQuestionDTO);

	SurveyQuestionDTO getQuestions(Long surveyId);

	SurveyQuestionDTO getQuestion(Long surveyId, Long questionId);

	void deleteSurvey(Long surveyId);

	void deleteQuestion(Long questionId);

	void deleteOption(Long optionId);

	void updateQuestions(SurveyQuestionDTO surveyQuestionDTO);

}
