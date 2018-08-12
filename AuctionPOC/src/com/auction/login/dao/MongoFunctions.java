package com.auction.login.dao;

public interface MongoFunctions {
	public boolean validateUser(String username, String password);

	public boolean changePassword(String username, String password);

	public String getObjectID(String username, String emailAddress);

	public boolean doUserExists(String username); 

	public boolean addUser(String name, String username, String emailAddress, long phonenumber, String password);
}
