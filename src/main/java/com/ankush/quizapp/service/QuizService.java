package com.ankush.quizapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ankush.quizapp.dao.QuizDao;
import com.ankush.quizapp.model.Quiz;

@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		
	Quiz quiz = new Quiz();
	quiz.setTitle( title );
    
	
	}

}
