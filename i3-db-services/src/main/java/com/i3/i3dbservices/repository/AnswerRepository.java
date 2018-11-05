package com.i3.i3dbservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.i3.i3dbservices.model.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long>{
 List<Answer> findByQuestionId(Long questionId);
}
