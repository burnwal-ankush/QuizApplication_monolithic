package com.ankush.quizapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ankush.quizapp.model.Question;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer>{

	List<Question> findByCategory(String category);

	List<Question> findRandomQuestionsByCategory(@Param("category") String category, @Param("numQ") Integer numQ);

}
