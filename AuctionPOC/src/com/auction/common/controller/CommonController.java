package com.auction.common.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

	public CommonController() {
		System.out.println(">> Inside CommonController()");
	}

	@RequestMapping("/auctionPage")
	public String startApp() {
		return "home-page";
	}
	
	@RequestMapping("/addItem")
	public String addItem() {
		return "add-item";
		
	}
	
	@RequestMapping("/formPage")
	public String getFormData(HttpServletRequest request) throws FileNotFoundException {
		System.out.println("Name : " + request.getParameter("q1"));
		System.out.println("Tags : " + request.getParameter("q2"));
		//System.out.println("Image : " + request.getParameter("image"));
		String image = request.getParameter("image");
		try {
			FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\Kartik\\Desktop\\" + request.getParameter("q3")));
			fos.write(Base64.getDecoder().decode(image.split(",")[1]));
			fos.flush();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//System.out.println("File Name : " + request.getParameter("q3"));
		System.out.println("Desc : " + request.getParameter("q4"));
		return "home-page";
	}
}
