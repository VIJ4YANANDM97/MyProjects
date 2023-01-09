package com.project.restaurant.manager;

import java.util.List;

import com.project.restaurant.constant.Item;
import com.project.restaurant.constant.RestaurantBill;

public class RestaurantBillManager {
	
	private static RestaurantBillManager restaurantBillManager = new RestaurantBillManager();
	
	public static RestaurantBillManager getInstance() {
		return restaurantBillManager;
	}
	
	public RestaurantBill createRestaurantBill(int billNumber,int numberOfItem,String date,String customerName,List<Item> items) {
		
		RestaurantBill restaurantBill = new RestaurantBill(billNumber, numberOfItem, date, customerName, items);
		return restaurantBill;
		
	}
	

}
