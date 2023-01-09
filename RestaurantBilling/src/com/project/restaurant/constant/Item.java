package com.project.restaurant.constant;

public class Item {
	
	private int itemNumber;
	private int numberOfItem;
	private int billnumber;
	
	public Item(int billnumber,int itemNumber,int numberOfItem) {
		
		this.billnumber = billnumber;
		this.itemNumber = itemNumber;
		this.numberOfItem = numberOfItem;
		
	}

	public int getItemNumber() {
		return itemNumber;
	}

	public int getNumberOfItem() {
		return numberOfItem;
	}

	public int getBillnumber() {
		return billnumber;
	}

}
