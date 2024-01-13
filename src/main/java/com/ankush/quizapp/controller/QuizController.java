package com.ankush.quizapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ankush.quizapp.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController 
{
	@Autowired
	QuizService quizService;
	
	@PostMapping("create")
	ResponseEntity<String> createQuiz( @RequestParam String category, @RequestParam int numQ, @RequestParam String title ) //to request url parameters
	{
		//return new ResponseEntity<>(" I am here", HttpStatus.OK ); //to return response , we have to create a new object of response entity
		return quizService.createQuiz( category, numQ, title);
	}
}
