package com.auction.common.model;

import java.util.ArrayList;

public class Item {

	private String _id;
	private String productName;
	private String productDescription;
	private ArrayList<ImagesPathAndName> images;
	private ArrayList<String> tags;
	private String dateAdded;
	private double price;
	private int viewCount;
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Item(String productName, String productDescription, ArrayList<ImagesPathAndName> images, ArrayList<String> tags,
			String dateAdded, double price, int viewCount, String username) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.images = images;
		this.tags = tags;
		this.dateAdded = dateAdded;
		this.price = price;
		this.viewCount = viewCount;
		this.username = username;
	}

	@Override
	public String toString() {
		return "Item [productName=" + productName + ", productDescription=" + productDescription + ", images=" + images
				+ ", tags=" + tags + ", dateAdded=" + dateAdded + ", price=" + price + ", viewCount=" + viewCount + "]";
	}

	public Item(String productName, String productDescription, ArrayList<ImagesPathAndName> images, ArrayList<String> tags,
			String dateAdded, double price, int viewCount) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.images = images;
		this.tags = tags;
		this.dateAdded = dateAdded;
		this.price = price;
		this.viewCount = viewCount;
	}

	public Item(String _id, String productName, String productDescription, ArrayList<ImagesPathAndName> images,
			ArrayList<String> tags, String dateAdded, double price, int viewCount) {
		super();
		this._id = _id;
		this.productName = productName;
		this.productDescription = productDescription;
		this.images = images;
		this.tags = tags;
		this.dateAdded = dateAdded;
		this.price = price;
		this.viewCount = viewCount;
	}

	public Item() {
		super();
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public ArrayList<ImagesPathAndName> getImages() {
		return images;
	}

	public void setImages(ArrayList<ImagesPathAndName> images) {
		this.images = images;
	}

	public ArrayList<String> getTags() {
		return tags;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

}
