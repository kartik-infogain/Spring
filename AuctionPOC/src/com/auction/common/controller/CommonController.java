package com.auction.common.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.auction.common.dao.CommonDatabaseFunctions;
import com.auction.common.model.ImagesPathAndName;
import com.auction.common.model.Item;
import com.auction.utility.filecopy.FileCopy;

@Controller
public class CommonController {

	@Resource(name = "commonProperties")
	private Properties properties;

	@Resource(name = "dbFunction")
	private CommonDatabaseFunctions dbFunctions;

	@Resource(name = "fileCopy")
	private FileCopy fileCopy;

	public CommonController() {
		System.out.println(">> Inside CommonController()");
	}

	@RequestMapping("/auctionPage")
	public String startApp() {
		// System.out.println(properties.getProperty("mongoDBHostName"));
		return "home-page";
	}

	@RequestMapping("/addItem")
	public String addItem() {
		return "add-item";
	}

	@RequestMapping("/form")
	public String getFormData(HttpServletRequest request) {
		System.out.println("Inside : form data");
		String productName = request.getParameter("productName");
		System.out.println(productName);
		String image = request.getParameter("image");
		String tag = request.getParameter("tags");
		System.out.println(tag);
		double price = Double.parseDouble(request.getParameter("price"));
		String filename = request.getParameter("fileName");
		String productDescription = request.getParameter("desc");
		String username = request.getParameter("username");

		// Logging
		System.out.println("Product Name : " + productName);
		System.out.println("Tags : " + tag);
		System.out.println("Price  : " + price);
		System.out.println("File Name : " + filename);
		System.out.println("Product Description : " + productDescription);
		System.out.println("Username : " + username);

		// Copying image
		String imagePath = fileCopy.fileCopied(username, productName, filename, image);
		// Intializing the item
		ArrayList<ImagesPathAndName> images = new ArrayList<>();
		images.add(new ImagesPathAndName(filename, imagePath));
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		String dateAdded = formatter.format(date);
		//ArrayList<String> tags = (ArrayList<String>) Arrays.asList(tag.split(" "));
		ArrayList<String> tags = new ArrayList<>();
		String[] t = tag.split(" ");
		for(String t1 : t) {
			tags.add(t1);
		}
		Item item = null;
		item = new Item(productName, productDescription, images, tags, dateAdded, price, 0, username);
		
		// DB Operation
		if(dbFunctions.insertItem(item)) {
			System.out.println("Inserted Item : " + productName);
		} else {
			System.out.println("Error while inserting");
		}
		return "home-page";
	}
	
	
	@RequestMapping(value="/getItems/{username}", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody ArrayList<Item> getItems(@PathVariable String username) {
		ArrayList<Item> items = new ArrayList<>();
		System.out.println(username);
		//dbFunctions.getItemsByUsername("null");
		items = dbFunctions.getItemsByUsername(username);
		return items;
	}
}
