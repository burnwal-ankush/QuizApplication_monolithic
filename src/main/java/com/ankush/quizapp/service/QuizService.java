package com.ankush.quizapp.service;

import com.ankush.quizapp.dao.QuestionDAO;
import com.ankush.quizapp.model.Question;
import com.ankush.quizapp.model.Response;
import com.ankush.quizapp.wrapper.QuestionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ankush.quizapp.dao.QuizDao;
import com.ankush.quizapp.model.Quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDAO questionDAO;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        try {
            List<Question> questionList = questionDAO.findRandomQuestionsByCategory(category, numQ);
            Quiz quiz = new Quiz();
            quiz.setTitle(title);
            quiz.setQuestions(questionList);
            quizDao.save(quiz);

            return new ResponseEntity<>("Quiz created successfully", HttpStatus.CREATED);
        }catch (Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<>("Unable to create quiz",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        try{
            Optional<Quiz> quizOptional = quizDao.findById(id);
            List<Question> questionsFromDB = quizOptional.get().getQuestions();
            List<QuestionWrapper> questionForUser = new ArrayList<>();
            for(Question q : questionsFromDB )
            {
                QuestionWrapper qw = new QuestionWrapper(q.getQuizId(),q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
                questionForUser.add(qw);
            }
            return new ResponseEntity<>(questionForUser,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        try
        {
            Optional<Quiz> quizOptional = quizDao.findById(id);
            List<Question> questions = quizOptional.get().getQuestions();
            int i = 0;
            Integer correctAnswers = 0;
            for(Response response :responses)
            {
                if(response.getResponse().equals(questions.get(i).getRightAnswer()))
                    correctAnswers++;
                i++;
            }
            return new ResponseEntity<>(correctAnswers,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
