package com.project.restaurant.launcher;

import java.util.Scanner;

import com.projet.restaurant.store.DataStore;

public class launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		DataStore.load();
		String name,password;
		
		int login = 0;
		
		Scanner sc = new Scanner(System.in);
		
		while(login == 0) {
			
			System.out.println("\n\nEnter Admin ID : ");
			name = sc.nextLine();

			System.out.println("\nPassword : ");
			password = sc.nextLine();
			
			if(name.equals("admin") && name.equals("admin")) {
				
				System.out.println("\n\nLogin Successfull");
				
				
				login = 1;
				
			}
			
			if(login == 0) {
				
				System.out.println("Invalid User");
				
			}
		}
		
		RestaurantMenu.mainMenu();
		
		

	}

}
