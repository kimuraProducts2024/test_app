package com.example.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.quiz.entity.Quiz;
import com.example.quiz.repository.QuizRepository;
import com.example.quiz.service.QuizService;

@SpringBootApplication
public class QuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args);
	}
	
	@Autowired
	QuizService service;
	
	@Autowired
	QuizRepository repository;
	
	private void execute() {
		// 登録処理
        // setup();
		// 全件取得
        // showList();
		// 一件取得
        // showOne();
		// 更新処理
        // updateQuiz();
		// 削除処理
        // deleteQuiz();
		// クイズを実行する
		// doQuiz();
	}

	private void setup() {
		System.out.println("--------- 登録処理開始 ----------");
		// エンティティ生成
		Quiz quiz1 = new Quiz(null, "「Java」はオブジェクト指向言語である。", true, "登録太郎");
		Quiz quiz2 = new Quiz(null, "「Spring Data」はデータアクセスに関する機能を提供する。", true, "登録太郎");
		Quiz quiz3 = new Quiz(null, "プログラムが沢山配置されているサーバーのことを「ライブラリ」という。", false, "登録太郎");
		Quiz quiz4 = new Quiz(null, "「@Component」はインスタンス生成アノテーションである。", true, "登録太郎");
		Quiz quiz5 = new Quiz(null, "「Spring MVC」にはControllerの概念がない。", false, "登録太郎");
		// リストにエンティティを格納
		List<Quiz> quizList = new ArrayList<>();
		Collections.addAll(quizList, quiz1, quiz2, quiz3, quiz4, quiz5);
		// 登録実行
		for(Quiz quiz : quizList) {
			service.insertQuiz(quiz);
		}
		System.out.println("--------- 登録処理完了 ----------");
	}
	
	private void showList() {
		System.out.println("--------- 全件取得開始 ----------");
		// リポジトリを使用して全件取得
		Iterable<Quiz> quizzes = service.selectAll();
		for(Quiz quiz : quizzes) {
			System.out.println(quiz);
		}
		System.out.println("--------- 全件取得完了 ----------");
	}
	
	private void showOne() {
		System.out.println("--------- 1件取得開始 ----------");
		// リポジトリを使用して１件取得
		Optional<Quiz> quizOpt = service.selectOneById(1);
		if(quizOpt.isPresent()) {
			System.out.println(quizOpt.get());
		} else {
			System.out.println("該当する問題が存在しません。");
		}
		System.out.println("--------- 1件取得完了 ----------");
	}
	
	private void updateQuiz() {
		System.out.println("--------- 更新処理開始 ----------");
		// 変更したいエンティティを生成する
		Quiz quiz1 = new Quiz(1, "[Spring]はフレームワークですか？", true, "変更タロウ");
		service.updateQuiz(quiz1);
		System.out.println("更新したデータは" + quiz1 + "です。");
		System.out.println("--------- 更新処理完了 ----------");
	}
	
	private void deleteQuiz() {
		System.out.println("--------- 削除処理開始 ----------");
		// 削除実行
		System.out.println("削除するデータは" + service.selectOneById(2) + "です。");
		service.deleteQuizById(2);
		System.out.println("--------- 削除処理完了 ----------");
	}
	
	// ランダムでクイズを取得して、正解／不正解を判定する
	private void doQuiz() {
		System.out.println("--------- クイズ取得開始 ----------");
		Optional<Quiz> quizOpt = service.selectOneRandomQuiz();
		if(quizOpt.isPresent()) {
			System.out.println(quizOpt.get());
		} else {
			System.out.println("該当する問題が存在しません。");
		}
		
		Boolean myAnswer = false;
		Integer id = quizOpt.get().getId();
		if(service.checkQuiz(id, myAnswer)) {
			System.out.println("正解です。");
		} else {
			System.out.println("不正解です。");
		}
		
		System.out.println("--------- クイズ取得完了 ----------");
	}
}
