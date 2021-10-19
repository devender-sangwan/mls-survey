package org.mls.surveyconduct.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.mls.surveyconduct.dto.AddSurveyQuestionDTO;
import org.mls.surveyconduct.dto.SurveyDTO;
import org.mls.surveyconduct.dto.SurveyQuestionDTO;
import org.mls.surveyconduct.service.SurveyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/surveys/")
@Validated
public class SurveyController {

	private SurveyService surveyService;

	public SurveyController(SurveyService surveyService) {
		this.surveyService = surveyService;
	}

	@GetMapping
	public ResponseEntity<List<SurveyDTO>> getAllSurveys() {
		return new ResponseEntity<>(surveyService.getAllSurveys(), HttpStatus.OK);
	}

	@GetMapping("{surveyId}")
	public ResponseEntity<Object> getSurvey(
			@PathVariable @Min(value = 1, message = "Survey Id must be greater than zero") Long surveyId) {
		return new ResponseEntity<>(surveyService.getSurvey(surveyId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Object> createSurvey(@Valid @RequestBody SurveyDTO surveyDTO) {
		surveyService.createSurvey(surveyDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("{surveyId}/questions")
	public ResponseEntity<SurveyQuestionDTO> getQuestions(@PathVariable Long surveyId) {
		return new ResponseEntity<>(surveyService.getQuestions(surveyId), HttpStatus.OK);
	}

	@GetMapping("{surveyId}/questions/{questionId}")
	public ResponseEntity<SurveyQuestionDTO> getQuestionInSurvey(@PathVariable Long surveyId,
			@PathVariable Long questionId) {
		return new ResponseEntity<>(surveyService.getQuestion(surveyId, questionId), HttpStatus.OK);
	}

	@PostMapping("{surveyId}/questions")
	public ResponseEntity<Object> addQuestions(@PathVariable Long surveyId,
			@Valid @RequestBody AddSurveyQuestionDTO addSurveyQuestionDTO) {
		addSurveyQuestionDTO.setSurveyId(surveyId);
		surveyService.addQuestions(addSurveyQuestionDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("{surveyId}/questions")
	public ResponseEntity<Object> updateQuestions(@PathVariable Long surveyId,
			@Valid @RequestBody SurveyQuestionDTO surveyQuestionDTO) {
		surveyQuestionDTO.setSurveyId(surveyId);
		surveyService.updateQuestions(surveyQuestionDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("{surveyId}")
	public ResponseEntity<Object> deleteSurvey(@PathVariable final Long surveyId) {
		surveyService.deleteSurvey(surveyId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/questions/{questionId}")
	public ResponseEntity<Object> deleteQuestion(@PathVariable final Long questionId) {
		surveyService.deleteQuestion(questionId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
