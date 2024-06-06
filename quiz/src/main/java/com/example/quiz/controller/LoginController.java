package com.example.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/")
	public String showLogin(Model model) {
		model.addAttribute("title", "ログイン画面");
		return "login";
	}
}
