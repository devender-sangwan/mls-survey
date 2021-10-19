package org.mls.survey.submission.repository;

import org.mls.survey.submission.model.SurveySubmission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveySubmissionRepository extends JpaRepository<SurveySubmission, Long> {

}
