package com.projet.restaurant.store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.project.restaurant.constant.Item;
import com.project.restaurant.constant.Items;
import com.project.restaurant.constant.RestaurantBill;
import com.project.restaurant.manager.ItemManager;
import com.project.restaurant.manager.ItemsManager;
import com.project.restaurant.manager.RestaurantBillManager;

public class DataStore {

	private static List<Item> itemList = new ArrayList<>();
	private static List<Items> itemsList = new ArrayList<>();
	private static List<RestaurantBill> restaurantBillList = new ArrayList<>();
	private static Map<Integer,List<Item>> itemMap = new TreeMap<>();
	
	public static void load() {
		loadItem();
		loadItems();
		loadRestaurantBill();
	}
	
	private static void loadItem() {
		
		Connection connection = null;
        String host="localhost";
        String port="5432";
        String db_name="Restaurant";
        String username="postgres";
        String password="admin";
        String query = "SELECT * FROM item";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+db_name+"", ""+username+"", ""+password+"");
            if (connection != null) {
            //    System.out.println("Connection OK");
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()) {
                	Item item = ItemManager.getInstance().createItem(rs.getInt("billnumber"),rs.getInt("itemnumber"), rs.getInt("numberofitem"));
                	itemList.add(item);
                	
                	if(itemMap.containsKey(item.getBillnumber())) {
                		
                		itemMap.get(item.getBillnumber()).add(item);
                		
                	}else {
                		
                		List<Item> itemMapList = new ArrayList<>();
                		itemMapList.add(item);
                		itemMap.put(item.getBillnumber(), itemMapList);
                		
                	}
                }
            } else {
                System.out.println("Connection Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
	}
	
	private static void loadItems() {
	
		Connection connection = null;
        String host="localhost";
        String port="5432";
        String db_name="Restaurant";
        String username="postgres";
        String password="admin";
        String query = "SELECT * FROM items";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+db_name+"", ""+username+"", ""+password+"");
            if (connection != null) {
            //    System.out.println("Connection OK");
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()) {
                	Items items = ItemsManager.getInstance().createItems(rs.getInt("itemnumber"),rs.getString("itemname"), rs.getInt("price"));
                	itemsList.add(items);
                }
            } else {
                System.out.println("Connection Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
	}
	
	private static void loadRestaurantBill() {
		
		Connection connection = null;
        String host="localhost";
        String port="5432";
        String db_name="Restaurant";
        String username="postgres";
        String password="admin";
        String query = "SELECT * FROM restaurantbill";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+db_name+"", ""+username+"", ""+password+"");
            if (connection != null) {
            //    System.out.println("Connection OK");
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()) {
                	RestaurantBill restaurantBill = RestaurantBillManager.getInstance().createRestaurantBill(
                			rs.getInt("billnumber"), rs.getInt("numberofitem"), rs.getString("date"), rs.getString("customername"), itemMap.get(rs.getInt("billnumber")));
                	restaurantBillList.add(restaurantBill);
                }
            } else {
                System.out.println("Connection Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
	}
	
	public static void addItems() {
		
		int itemNumber,price;
		String itemName;
		
		System.out.println("\n\nEnter item number : ");
		Scanner sc = new Scanner(System.in);
		itemNumber = sc.nextInt();
		sc.nextLine();
		
		System.out.println("\nEnter item name : ");
		itemName = sc.nextLine();
		
		System.out.println("\nEnter item price : ");
		price = sc.nextInt();
		sc.nextLine();
		
		Connection connection = null;
        String host="localhost";
        String port="5432";
        String db_name="Restaurant";
        String username="postgres";
        String password2="admin";
        String query = "INSERT INTO items\n"
        		+ "VALUES("+itemNumber+",'"+itemName+"',"+price+");";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+db_name+"", ""+username+"", ""+password2+"");
            if (connection != null) {
            //    System.out.println("Connection OK");
                Statement stmt = connection.createStatement();
                stmt.executeUpdate(query);
                
            } else {
                System.out.println("Connection Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
        Items items = ItemsManager.getInstance().createItems(itemNumber, itemName, price);
        itemsList.add(items);
		
	}
	
	public static void createRestaurantBill() {
		
		int billNumber;
		int numberOfItem;
		String date;
		String customerName;
		List<Item> item = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\nEnter table number : ");
		billNumber = sc.nextInt();
		sc.nextLine();
		
		System.out.println("\nEnter number of items : ");
		numberOfItem = sc.nextInt();
		sc.nextLine();
		
		System.out.println("\nEnter customer name : ");
		customerName = sc.nextLine();
		
		String pattern = "dd MM yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String dateOrder = simpleDateFormat.format(new Date());
		
		int flag = 0;
		if(flag==0) {
			
			Connection connection = null;
	        String host="localhost";
	        String port="5432";
	        String db_name="Restaurant";
	        String username="postgres";
	        String password2="admin";
	        String query = "INSERT INTO restaurantbill\n"
	        		+ "VALUES("+billNumber+","+numberOfItem+",'"+dateOrder+"','"+customerName+"');";
	        try {
	            Class.forName("org.postgresql.Driver");
	            connection = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+db_name+"", ""+username+"", ""+password2+"");
	            if (connection != null) {
	            //    System.out.println("Connection OK");
	                Statement stmt = connection.createStatement();
	                stmt.executeUpdate(query);
	                
	            } else {
	                System.out.println("Connection Failed");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			
			
		}
		
		for(int i=0;i<numberOfItem;i++) {
			
			int itemNumber;
			System.out.println("\n\nEnter item number : ");
			itemNumber = sc.nextInt();
			System.out.println("\nEnter number of item : ");
			int numberOfItems = sc.nextInt();
			
			Item itemTemp = ItemManager.getInstance().createItem(billNumber, itemNumber, numberOfItems);
			item.add(itemTemp);
			
			Connection connection = null;
	        String host="localhost";
	        String port="5432";
	        String db_name="Restaurant";
	        String username="postgres";
	        String password2="admin";
	        String query = "INSERT INTO item\n"
	        		+ "VALUES("+billNumber+","+itemNumber+","+numberOfItem+");";
	        
	        
	        
	        
	        try {
	            Class.forName("org.postgresql.Driver");
	            connection = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+db_name+"", ""+username+"", ""+password2+"");
	            if (connection != null) {
	            //    System.out.println("Connection OK");
	                Statement stmt = connection.createStatement();
	                stmt.executeUpdate(query);
	                
	            } else {
	                System.out.println("Connection Failed");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			
			
		}
		
		itemMap.put(billNumber, item);
		
		RestaurantBill restaurantBill = RestaurantBillManager.getInstance().createRestaurantBill(
				billNumber, numberOfItem, dateOrder, customerName, item);
		restaurantBillList.add(restaurantBill);
		
		
		
		
		
		
	}
	
	public static void viewItems() {
    	
		System.out.println("Item Number   Item Name         Price");
		
		for(Items items : itemsList) {
			
			System.out.println(String.format("%-14d%-18s%d", items.getItemNumber(),items.getItemName(),items.getItemPrice()));
		}
    	
    	
    }
	
	public static void appendRestaurantBill() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\nEnter table number :");
		
		int billNumber;
		billNumber = sc.nextInt();
		
		
		int numberOfItem;
		System.out.println("Enter Number items to append :");
		numberOfItem = sc.nextInt();
		
		for(RestaurantBill rb : restaurantBillList) {
			
			if(rb.getBillNumber()==billNumber) {
				
				for(int i=0; i<numberOfItem;i++) {
					
					System.out.println("\nEnter the item number : ");
					int itemNumber = sc.nextInt();
					System.out.println("Enter number of items : ");
					int numberOfItemtemp = sc.nextInt();
					
					Item item = ItemManager.getInstance().createItem(billNumber, itemNumber, numberOfItemtemp);
					rb.getItems().add(item);
				//	itemMap.get(billNumber).add(item);
					
					
					
					
				}
				
				rb.setNumberOfItem(rb.getNumberOfItem()+numberOfItem);
				
			}
			
		}
		
		System.out.println("Bill Appened Successfully.");
		
	}
	
	public static void payment() {
		
		int billNumber;
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\nEnter table number : ");
		billNumber = sc.nextInt();
		
		for(RestaurantBill rb : restaurantBillList) {
					
				if(rb.getBillNumber()==billNumber) {
					
						
						displayBill(rb);
						int amount = calculateBill(rb);
						System.out.println("\n----------------------------------\nTotal                       "+amount+"\n----------------------------------");
						
						System.out.println("\nPress 1 to confirm payment...");
						int confirm = sc.nextInt();
						if(confirm == 1) {
							
							remove(rb);
							
						}
				}
					
		}
		
	}
	
	private static void remove(RestaurantBill rb) {
		// TODO Auto-generated method stub
		
		removeItem(rb);
		Connection connection = null;
        String host="localhost";
        String port="5432";
        String db_name="Restaurant";
        String username="postgres";
        String password2="admin";
        String query = "DELETE FROM restaurantbill\n"
        		+ "WHERE billnumber = "+rb.getBillNumber()+";";
        
        
        
        
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+db_name+"", ""+username+"", ""+password2+"");
            if (connection != null) {
            //    System.out.println("Connection OK");
                Statement stmt = connection.createStatement();
                stmt.executeUpdate(query);
                
            } else {
                System.out.println("Connection Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
	}

	private static void removeItem(RestaurantBill rb) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
        String host="localhost";
        String port="5432";
        String db_name="Restaurant";
        String username="postgres";
        String password2="admin";
        String query = "DELETE FROM item\n"
        		+ "WHERE billnumber = "+rb.getBillNumber()+";";
        
        
        
        
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+db_name+"", ""+username+"", ""+password2+"");
            if (connection != null) {
            //    System.out.println("Connection OK");
                Statement stmt = connection.createStatement();
                stmt.executeUpdate(query);
                
            } else {
                System.out.println("Connection Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

	private static void displayBill(RestaurantBill rb) {
		// TODO Auto-generated method stub
		
		System.out.println("\n\nTable Number : "+rb.getBillNumber());
		System.out.println("Customer Name : "+ rb.getCustomerName());
		System.out.println("\nS.No Item Name         Price     Quantity\n");
		int sno = 1;
		
		
		
		for(Item item : rb.getItems()) {
			
			for(Items items : itemsList) {
				
				if(item.getItemNumber() == items.getItemNumber()) {
					
					System.out.println(String.format("%-5d%-18s%-10d%d", sno++,items.getItemName(),items.getItemPrice(),item.getNumberOfItem()));
					
				}
				
			}
			
		}
		
		
		
	}

	private static int calculateBill(RestaurantBill rb) {
		// TODO Auto-generated method stub
		
		List<Item> itemListTemp = rb.getItems();
		int total = 0;
		
		for(Item item : itemListTemp) {
			
			int itemPrice =0;
			for(Items items : itemsList) {
				if(items.getItemNumber()==item.getItemNumber())
					itemPrice = items.getItemPrice();
			}
			
			total += itemPrice * item.getNumberOfItem();
			
		}
		
		return total;
	}
				
			
	
}

	


