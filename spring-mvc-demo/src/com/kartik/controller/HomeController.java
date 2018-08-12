package com.kartik.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kartik.model.Student;

@Controller
public class HomeController {

	public HomeController() {
		System.out.println(">> Inside HomeController()");
	}

	@RequestMapping("/")
	public String startApp() {
		return "main-menu";
	}

	@RequestMapping("/showForm")
	public String showForm() {
		return "show-form";
	}

	@RequestMapping("/processForm")
	public String processForm() {
		return "process-form";
	}

	// Adding data to model
	@RequestMapping("/processFormVersion2")
	public String addDataToModel(HttpServletRequest request, Model model) {

		// Read form data
		String name = request.getParameter("studentName");

		name = "Yo! " + name.toUpperCase();

		// Add data to model
		model.addAttribute("message", name);

		return "hello-world";
	}

	@RequestMapping("/formTags")
	public String formTagsExample(Model model) {
		model.addAttribute("student", new Student());
		return "form-tag";
	}

	@RequestMapping("/formTagsProcessForm")
	public String formTagsProcessForm(@ModelAttribute("student") Student student) {
		System.out.println("Student : " + student.getFirstName() + " " + student.getLastName());
		return "welcome-student";
	}
}
