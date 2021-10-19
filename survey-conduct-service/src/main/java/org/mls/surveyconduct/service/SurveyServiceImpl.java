package org.mls.surveyconduct.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.mls.surveyconduct.dto.AddSurveyQuestionDTO;
import org.mls.surveyconduct.dto.QuestionDTO;
import org.mls.surveyconduct.dto.SurveyDTO;
import org.mls.surveyconduct.dto.SurveyQuestionDTO;
import org.mls.surveyconduct.exception.ResourceNotFoundException;
import org.mls.surveyconduct.mapper.SurveyMapper;
import org.mls.surveyconduct.model.Option;
import org.mls.surveyconduct.model.Question;
import org.mls.surveyconduct.model.Survey;
import org.mls.surveyconduct.repository.OptionRepository;
import org.mls.surveyconduct.repository.QuestionRepository;
import org.mls.surveyconduct.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyServiceImpl implements SurveyService {

	@Autowired
	private SurveyRepository surveyRepo;
	@Autowired
	private QuestionRepository questionRepo;
	@Autowired
	private OptionRepository optionRepo;

	@Transactional
	@Override
	public void createSurvey(final SurveyDTO surveyDTO) {
		Survey survey = SurveyMapper.mapToEntity(surveyDTO);
		System.out.println("dd = " + survey.getPublished());
		surveyRepo.save(survey);
	}

	@Override
	public List<SurveyDTO> getAllSurveys() {
		List<Survey> surveys = surveyRepo.findAll();
		List<SurveyDTO> surveyDtoList = new ArrayList<>(0);
		if (Objects.nonNull(surveys)) {
			surveyDtoList = surveys.stream().map(survey -> SurveyMapper.mapToDto(survey)).collect(Collectors.toList());
		}
		return surveyDtoList;
	}

	@Override
	public SurveyDTO getSurvey(final Long surveyId) {
		Survey survey = this.getSurveyEntity(surveyId);
		return SurveyMapper.mapToDto(survey);
	}

	private Survey getSurveyEntity(final Long surveyId) throws ResourceNotFoundException {
		Survey survey = surveyRepo.findById(surveyId).orElseThrow(
				() -> new ResourceNotFoundException(String.format("Survey[id: %d] does not exist", surveyId)));
		return survey;
	}

	@Transactional
	@Override
	public void addQuestions(@Valid final AddSurveyQuestionDTO surveyQuestionDTO) {
		this.getSurveyEntity(surveyQuestionDTO.getSurveyId());
		Set<Question> questions = SurveyMapper.mapToEntity(surveyQuestionDTO);
		questionRepo.saveAll(questions);
	}

	@Override
	public SurveyQuestionDTO getQuestions(final Long surveyId) {
		Survey survey = this.getSurveyEntity(surveyId);
		SurveyQuestionDTO dto = new SurveyQuestionDTO();
		dto.setSurveyId(surveyId);
		dto.setQuestions(SurveyMapper.mapToDto(survey.getQuestions()));
		return dto;
	}

	@Override
	public SurveyQuestionDTO getQuestion(final Long surveyId, final Long questionId) {
		SurveyQuestionDTO dto = this.getQuestions(surveyId);
		QuestionDTO questionDto = dto.getQuestions().stream().filter(ques -> questionId.equals(ques.getQuestionId()))
				.findFirst().orElseThrow(() -> new ResourceNotFoundException(
						String.format("Question[id: %d] does not exist", questionId)));
		dto.getQuestions().clear();
		dto.getQuestions().add(questionDto);
		return dto;
	}

	@Transactional
	@Override
	public void deleteSurvey(final Long survetyId) {
		surveyRepo.delete(this.getSurveyEntity(survetyId));
	}

	@Transactional
	@Override
	public void deleteQuestion(final Long questionId) {
		Question question = questionRepo.findById(questionId).orElseThrow(
				() -> new ResourceNotFoundException(String.format("Question[id: %d] does not exist", questionId)));
		questionRepo.delete(question);
	}

	@Transactional
	@Override
	public void deleteOption(final Long optionId) {
		Option option = optionRepo.findById(optionId).orElseThrow(
				() -> new ResourceNotFoundException(String.format("Option[id: %d] does not exist", optionId)));
		optionRepo.delete(option);
	}

	@Transactional
	@Override
	public void updateQuestions(@Valid final SurveyQuestionDTO surveyQuestionDTO) {
		Survey survey = this.getSurveyEntity(surveyQuestionDTO.getSurveyId());
		Set<Question> questions = SurveyMapper.mapToEntity(surveyQuestionDTO);
		questionRepo.saveAll(questions);
		
	}

}
