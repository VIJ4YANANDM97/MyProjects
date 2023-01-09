package com.project.restaurant.manager;

import com.project.restaurant.constant.Item;

public class ItemManager {
	
	private static ItemManager itemManager = new ItemManager();
	
	private ItemManager() {}
	
	public static ItemManager getInstance() {
		return itemManager;
	}
	
	public Item createItem(int billnumber,int itemNumber,int numberOfItem) {
		
		Item item = new Item(billnumber,itemNumber,numberOfItem);
		return item;
		
	}

}
