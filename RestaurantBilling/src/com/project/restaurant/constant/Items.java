package com.project.restaurant.constant;

public class Items {
	
	private int itemNumber;
	private String itemName;
	private int itemPrice;
	
	public Items(int itemNumber,String itemName,int itemPrice) {
		
		this.itemName = itemName;
		this.itemNumber = itemNumber;
		this.itemPrice = itemPrice;
		
	}

	public int getItemNumber() {
		return itemNumber;
	}

	public String getItemName() {
		return itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

}
