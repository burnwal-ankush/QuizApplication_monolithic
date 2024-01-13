package com.ankush.quizapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="question")
public class Question {
	
	@Id
	@Column(name="quiz_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer quizId;
	
	@Column(name="category")
	private String category;
	
	@Column(name="difficulty_level")
	private String difficultyLevel;
	
	@Column(name="option1")
	private String option1;
	
	@Column(name="option2")
	private String option2;
	
	@Column(name="option3")
	private String option3;
	
	@Column(name="option4")
	private String option4;
	
	@Column(name="question_title")
	private String questionTitle;
	
	@Column(name="right_answer")
	private String rightAnswer;

	public Integer getQuizId() {
		return quizId;
	}

	public void setQuizId(Integer quizId) {
		this.quizId = quizId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}

	@Override
	public String toString() {
		return "Question [quizId=" + quizId + ", category=" + category + ", difficultyLevel=" + difficultyLevel
				+ ", option1=" + option1 + ", option2=" + option2 + ", option3=" + option3 + ", option4=" + option4
				+ ", questionTitle=" + questionTitle + ", rightAnswer=" + rightAnswer + "]";
	}
	
	
	
}
