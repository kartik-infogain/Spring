package com.kartik.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	public HomeController() {
		System.out.println(">> Inside HomeController()");
	}

	@RequestMapping("/")
	public String showMyPage() {
		return "main-menu";
	}
}
