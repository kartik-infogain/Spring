package com.auction.common.dao;

import java.util.ArrayList;

import com.auction.common.model.Item;

public interface CommonDatabaseFunctions {
	public boolean insertItem(Item item);
	
	public ArrayList<Item> getItemsByUsername(String username);
}
