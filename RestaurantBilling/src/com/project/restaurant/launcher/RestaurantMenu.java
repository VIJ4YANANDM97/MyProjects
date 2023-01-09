package com.project.restaurant.launcher;

import java.util.Scanner;

import com.projet.restaurant.store.DataStore;

public class RestaurantMenu {
	
	public static void mainMenu() {
		
		int option =0;
		Scanner sc = new Scanner(System.in);
		
		while(option!=6) {
			
			System.out.println("\n\n1. Add new Table Bill");
			System.out.println("2. Add new item");
			System.out.println("3. Append to Table Bill");
			System.out.println("4. View Item");
			System.out.println("5. Payment");
			System.out.println("6. Logout");
			
			option = sc.nextInt();
			
			switch(option) {
			case 1:
				DataStore.createRestaurantBill();
				break;
			case 2:
				DataStore.addItems();
				break;
			case 3:
				DataStore.appendRestaurantBill();
				break;
			case 4:
				DataStore.viewItems();
				break;
			case 5:
				DataStore.payment();
				break;
			case 6:
				System.out.println("\n\nApplication Closed.");
				break;
			default:
				System.out.println("Invalid Entry.");
				break;
			
			
			}
			
			
		}
		
	}
	
	

}
