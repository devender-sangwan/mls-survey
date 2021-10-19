package org.mls.survey.submission.api;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.mls.survey.submission.dto.SurveySubmissionDTO;
import org.mls.survey.submission.model.SurveySubmission;
import org.mls.survey.submission.repository.SurveySubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/surveys/")
public class SurveySubmissionController {

	@Autowired
	private SurveySubmissionRepository repo;

	@PostMapping("{surveyId}/submission")
	public ResponseEntity<Object> submitSurvey(@RequestBody @Valid SurveySubmissionDTO submissionRequestDto) {
		// TODO move into service layer

		List<SurveySubmission> submissionList = this.mapToEntity(submissionRequestDto);
		repo.saveAll(submissionList);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	private List<SurveySubmission> mapToEntity(SurveySubmissionDTO submissionRequestDto) {
		List<SurveySubmission> submissionList = submissionRequestDto.getQuestions().stream().map(quesDto -> {
			ObjectMapper objMapper = new ObjectMapper();
			String ans = null;
			try {
				ans = objMapper.writer().writeValueAsString(quesDto.getAnswers());
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			return new SurveySubmission(submissionRequestDto.getSurveyId(), submissionRequestDto.getSurveyName(),
					quesDto.getQuestionId(), quesDto.getQuestion(), ans, submissionRequestDto.getSubmittedBy());

		}).collect(Collectors.toList());
		return submissionList;
	}
}
