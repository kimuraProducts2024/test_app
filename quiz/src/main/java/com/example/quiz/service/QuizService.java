package com.example.quiz.service;

import java.util.Optional;

import com.example.quiz.entity.Quiz;

public interface QuizService {
	/** クイズ情報を全件取得します **/
	Iterable<Quiz> selectAll();
	
	/** クイズ情報を、idをキーに１件取得します **/
	Optional<Quiz> selectOneById(Integer id);
	
	/** クイズ情報をランダムで１件取得します **/
	Optional<Quiz> selectOneRandomQuiz();
	
	/** クイズの正解／不正解を判定します **/
	Boolean checkQuiz(Integer id, Boolean myAnswer);
	
	/** クイズを登録します **/
	void insertQuiz(Quiz quiz);
	
	/** クイズを更新します **/
	void updateQuiz(Quiz quiz);
	
	/** クイズを削除します **/
	void deleteQuizById(Integer id);
}
