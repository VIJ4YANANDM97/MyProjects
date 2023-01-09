package com.project.restaurant.manager;

import com.project.restaurant.constant.Items;

public class ItemsManager {
	
	private static ItemsManager itemsManager = new ItemsManager();
	
	public static ItemsManager getInstance() {
		
		return itemsManager;
		
	}
	
	public Items createItems(int itemNumber,String itemName,int price) {
		
		Items items = new Items(itemNumber,itemName,price);
		return items;
		
	}

}
