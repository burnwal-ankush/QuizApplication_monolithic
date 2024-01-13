package com.ankush.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ankush.quizapp.dao.QuestionDAO;
import com.ankush.quizapp.quesion.Question;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDAO questionDAO;
	
	public ResponseEntity<List<Question>> getAllQuestions()
	{
		try {
			return new ResponseEntity<>( questionDAO.findAll(), HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>( new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		try {
			return new ResponseEntity<>(questionDAO.findByCategory(category),HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>( new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestion(Question question) {
		try
		{
			questionDAO.save(question);
			return new ResponseEntity<>("success",HttpStatus.CREATED);
		}
		catch( Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>("success",HttpStatus.NOT_ACCEPTABLE);
		
	}
	
}
