package org.mls.surveyconduct.mapper;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.mls.surveyconduct.dto.AddSurveyQuestionDTO;
import org.mls.surveyconduct.dto.OptionDTO;
import org.mls.surveyconduct.dto.QuestionDTO;
import org.mls.surveyconduct.dto.SurveyDTO;
import org.mls.surveyconduct.dto.SurveyQuestionDTO;
import org.mls.surveyconduct.model.Option;
import org.mls.surveyconduct.model.Question;
import org.mls.surveyconduct.model.Survey;

public class SurveyMapper {

	public static Survey mapToEntity(SurveyDTO surveyDTO) {
		return new Survey(surveyDTO.getName());
	}

	public static SurveyDTO mapToDto(Survey survey) {
		return new SurveyDTO(survey.getId(), survey.getName());
	}

	public static Set<Question> mapToEntity(AddSurveyQuestionDTO addSurveyQuestionDTO) {
		Set<Question> questions = addSurveyQuestionDTO.getQuestions().stream().map(quesDto -> {
			Question question = new Question(addSurveyQuestionDTO.getSurveyId(), quesDto.getQuestion());
			Set<Option> options = quesDto.getQuestionOptions().stream().map(optionDto -> {
				Option option = new Option(optionDto.getLabel());
				option.setQuestion(question);
				return option;
			}).collect(Collectors.toSet());
			question.setOptions(options);
			return question;
		}).collect(Collectors.toSet());
		return questions;
	}

	public static Set<Question> mapToEntity(SurveyQuestionDTO surveyQuestionDTO) {
		Set<Question> questions = surveyQuestionDTO.getQuestions().stream().map(quesDto -> {
			Question question = new Question(quesDto.getQuestionId(), surveyQuestionDTO.getSurveyId(),
					quesDto.getQuestion());
			Set<Option> options = quesDto.getQuestionOptions().stream().map(optionDto -> {
				Option option = new Option(optionDto.getId(), optionDto.getLabel());
				option.setQuestion(question);
				return option;
			}).collect(Collectors.toSet());
			question.setOptions(options);
			return question;
		}).collect(Collectors.toSet());
		return questions;
	}

	public static Set<QuestionDTO> mapToDto(Set<Question> questions) {
		Set<QuestionDTO> questionsDto = questions.stream().map(ques -> {
			Set<OptionDTO> optionsDto = ques.getOptions().stream().map(op -> {
				return new OptionDTO(op.getId(), op.getLabel());
			}).collect(Collectors.toSet());
			QuestionDTO question = new QuestionDTO(ques.getId(), ques.getLabel(), optionsDto);
			return question;
		}).collect(Collectors.toCollection(LinkedHashSet::new));
		return questionsDto;
	}

}
