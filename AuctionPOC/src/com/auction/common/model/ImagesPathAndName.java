package com.auction.common.model;

public class ImagesPathAndName {
	private String filename;
	private String filepath;

	@Override
	public String toString() {
		return "ImagesPathAndName [filename=" + filename + ", filepath=" + filepath + "]";
	}

	public ImagesPathAndName(String filename, String filepath) {
		super();
		this.filename = filename;
		this.filepath = filepath;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

}
