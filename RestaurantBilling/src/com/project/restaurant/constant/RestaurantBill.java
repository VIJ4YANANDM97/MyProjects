package com.project.restaurant.constant;

import java.util.List;

public class RestaurantBill {
	
	private int billNumber;
	private int numberOfItem;
	private String date;
	private String customerName;
	private List<Item> items;
	
	public RestaurantBill(int billNumber,int numberOfItem,String date,String customerName,List<Item> items) {
		
		this.billNumber = billNumber;
		this.numberOfItem = numberOfItem;
		this.date = date;
		this.customerName = customerName;
		this.items = items;
		
	}

	public int getBillNumber() {
		return billNumber;
	}

	public void setNumberOfItem(int numberOfItem) {
		this.numberOfItem = numberOfItem;
	}

	public int getNumberOfItem() {
		return numberOfItem;
	}

	public String getDate() {
		return date;
	}

	public String getCustomerName() {
		return customerName;
	}

	public List<Item> getItems() {
		return items;
	}
	
	
	
}
