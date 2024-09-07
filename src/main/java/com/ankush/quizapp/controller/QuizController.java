package com.ankush.quizapp.controller;

import com.ankush.quizapp.model.Response;
import com.ankush.quizapp.wrapper.QuestionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ankush.quizapp.service.QuizService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("/createQuiz")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) //to request url parameters
    {
        try {
            return quizService.createQuiz(category, numQ, title);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id) {
        try {
            return quizService.getQuizQuestions(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/submit/{id}")
    public ResponseEntity<Integer> submit(@PathVariable Integer id, @RequestBody List<Response> responses) {
        try {
            return quizService.calculateResult(id, responses);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
