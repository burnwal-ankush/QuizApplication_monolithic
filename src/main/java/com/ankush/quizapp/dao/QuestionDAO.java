package com.ankush.quizapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ankush.quizapp.quesion.Question;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer>{

	List<Question> findByCategory(String category);
	
}
