package com.ankush.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ankush.quizapp.dao.QuestionDAO;
import com.ankush.quizapp.model.Question;

@Service
public class QuestionService {

	private static final Logger logger = LoggerFactory.getLogger(QuestionService.class);

	@Autowired
	QuestionDAO questionDAO;

	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
			List<Question> questions = questionDAO.findAll();
			if (questions.isEmpty()) {
				logger.info("No questions found.");
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(questions, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error occurred while fetching questions", e);
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		try {
			List<Question> questions = questionDAO.findByCategory(category);
			if (questions.isEmpty()) {
				logger.info("No questions found for category: {}", category);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(questions, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error occurred while fetching questions by category", e);
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<String> addQuestion(Question question) {
		try {
			if (question == null) {
				logger.warn("Invalid question data.");
				return new ResponseEntity<>("Invalid data", HttpStatus.BAD_REQUEST);
			}
			questionDAO.save(question);
			logger.info("Question successfully added.");
			return new ResponseEntity<>("Question created successfully", HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("Error occurred while saving the question", e);
			return new ResponseEntity<>("Error creating question", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
