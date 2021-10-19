package org.mls.surveyconduct.repository;

import org.mls.surveyconduct.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
