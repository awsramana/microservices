package com.i3.i3dbservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.i3.i3dbservices.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
