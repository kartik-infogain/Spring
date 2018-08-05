package com.auction.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.auction.login.dao.MongoFunctions;
import com.auction.login.dao.MongoFunctionsImpl;
import com.auction.utility.email.SendEmail;

@Controller
public class LoginController {

	public LoginController() {
		System.out.println(">> Inside LoginController()");
	}

	@RequestMapping("/")
	public String startApp() {
		return "index";
	} 

	@RequestMapping("/homePage")
	public String homePage(HttpServletRequest request, Model model) {
		MongoFunctions mongoFunctions = new MongoFunctionsImpl();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + " " + password);
		if (username.equals("") && password.equals("")) {
			model.addAttribute("message", "<span style='color: red'>The username and password is required!</span>");
			return "index";
		} else if (mongoFunctions.validateUser(username, password)) {
			model.addAttribute("message", "Welcome " + username + "!");
			
			model.addAttribute("username", username);
			System.out.println(model.toString());
			return "home-page";
		} else {
			model.addAttribute("message", "<span style='color: red'>Invalid username or password!</span>");
			return "index";
		}

	}

	@RequestMapping("/forgetPassword")
	public String forgetPassword(HttpServletRequest request, Model model) {
		MongoFunctions mongoFunctions = new MongoFunctionsImpl();
		String to = request.getParameter("emailID");
		String username = request.getParameter("username");
		String _id = mongoFunctions.getObjectID(username, to);
		SendEmail sendEmail = new SendEmail();
		if (_id != null) {
			sendEmail.sendEmail(to, "Your ID is " + _id
					+ ". Please don't share it with anyone. Visit http://localhost:8082/AuctionPOC/changePassword to change the password");
			model.addAttribute("message", "<span style='color: yellow'>Email has been sent</span>");
			return "index";
		} else {
			model.addAttribute("message", "<span style='color: red'>Invalid Email Address or Username!</span>");
			return "index";
		}
	}

	@RequestMapping("/changePassword")
	public String changePassword() {
		return "forget-password";
	}

	@RequestMapping("/requestChange")
	public String requestChange(HttpServletRequest request, Model model) {
		MongoFunctions mongoFunctions = new MongoFunctionsImpl();
		String _id = request.getParameter("objectID");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		System.out.println(_id + " " + password + " " + confirmPassword);
		if (_id.equals("") && password.equals("") && confirmPassword.equals("")) {
			model.addAttribute("message", "<span style='color: red'>The username and password is required!</span>");
			return "forget-password";
		} else if (!password.equals(confirmPassword)) {
			model.addAttribute("message", "<span style='color: red'>Password should be same</span>");
			return "forget-password";
		} else if (mongoFunctions.changePassword(_id, confirmPassword)) {
			model.addAttribute("message", "<span style='color: green'>Password changed</span>");
			return "index";
		} else {
			model.addAttribute("message", "<span style='color: red'>ID is wrong</span>");
			return "forget-password";
		}
	}

	@RequestMapping("/register")
	public String register() {
		return "register";
	}

	@RequestMapping("/registerPage")
	public String registerPage(HttpServletRequest request, Model model) {
		MongoFunctions mongoFunctions = new MongoFunctionsImpl();
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String emailAddress = request.getParameter("emailID");
		String phone = request.getParameter("phonenumber");
		long phonenumber = Long.parseLong(phone);
		if (mongoFunctions.doUserExists(username)) {
			model.addAttribute("message", "<span style='color: red;'>Entered Username already exists</span>");
			return "register";
		} else if (phone.length() != 10) {
			model.addAttribute("message", "<span style='color: red;'>Phone number should have 10 digits</span>");
			return "register";
		} else if (mongoFunctions.addUser(name, username, emailAddress, phonenumber, password)) {
			model.addAttribute("message", "Welcome " + name + "!");
			model.addAttribute("username", username);
			return "home-page";
		}
		return "register";
	}
	@RequestMapping("/auctionPage/addItem")
	public String addItem() {
		return "add-item";
	}
}
