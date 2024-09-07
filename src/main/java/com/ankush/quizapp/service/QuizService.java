package com.ankush.quizapp.service;

import com.ankush.quizapp.dao.QuestionDAO;
import com.ankush.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ankush.quizapp.dao.QuizDao;
import com.ankush.quizapp.model.Quiz;

import java.util.List;

@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;

	@Autowired
	QuestionDAO questionDAO;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

	List<Question> questionList = questionDAO.findRandomQuestionsByCategory(category, numQ);
	Quiz quiz = new Quiz();
	quiz.setTitle( title );
	quiz.setQuestions(questionList);
	quizDao.save(quiz);

	return new ResponseEntity<>("Quiz created successfully", HttpStatus.CREATED);
	
	}

}
