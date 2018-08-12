package com.auction.utility.filecopy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class FileCopyLocalImpl implements FileCopy {

	@Override
	public String fileCopied(String username, String productName, String filename, String image) {
		File dir = null;
		try {
			dir = new File("F:\\auction-poc-images\\" + username + "\\" + productName);
			System.out.println(dir.getAbsolutePath());
			FileOutputStream fos = null;
			if (!dir.exists()) {
				if (dir.mkdirs()) {
					fos = new FileOutputStream(
							new File("F:\\auction-poc-images\\" + username + "\\" + productName + "\\" + filename));
					fos.write(Base64.getDecoder().decode(image.split(",")[1]));
					fos.flush();
					fos.close();
				} else {
					System.out.println("Something went wrong in directory creation");
				}
			} else {
				fos = new FileOutputStream(
						new File("F:\\auction-poc-images\\" + username + "\\" + productName + "\\" + filename));
				fos.write(Base64.getDecoder().decode(image.split(",")[1]));
				fos.flush();
				fos.close();
			}
			return dir.getAbsolutePath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
