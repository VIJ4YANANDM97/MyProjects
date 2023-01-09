package BusResvProject;

import java.sql.SQLException;
import java.util.Scanner;

public class busmain {
	public static void main (String args[]) throws SQLException {
		
		   
		    busDAO busdao=new busDAO();
		    
		   
				    int option=1;
				    busdao.displayBusInfo();
					try {
					Scanner scan=new Scanner(System.in);
					while(option==1) {
						System.out.println("Enter 1 for booking OR To Exit enter 2 : ");
						option = scan.nextInt();
						if(option==2) {	System.out.println("Thank you for using!"); break;}
						if(option==1) {
						       booking book= new booking();
						if(book.isavailable())
						{   
							bookingDAO bookingdao=new bookingDAO();
							bookingdao.addtoTable(book);
							System.out.println("Booked successfully! ");
						}
						else
							System.out.println("Sorry bus is full try another bus! ");
					}
					}   
					scan.close();
					}
					catch (Exception e) {
						// TODO: handle exception
						System.out.println(e);
					}
		         
			
	}
}
	

           

