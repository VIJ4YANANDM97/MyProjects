package BusResvProject;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class booking {
	String name;
	int busno;
	Date date;
	
	Scanner scan=new Scanner(System.in);
	booking() throws ParseException
	{
		System.out.println("Enter passenger name: ");
		this.name=scan.next();
		
		System.out.println("Enter Bus number: ");
		this.busno=scan.nextInt();
		
		System.out.println("Enter date(dd/mm/yyyy): ");
		String Datein=scan.next();
		SimpleDateFormat DATE=new SimpleDateFormat("dd/MM/yyyy");
		this.date=DATE.parse(Datein);
		
		
	}
	
	public boolean isavailable() throws SQLException {
		
		busDAO busdao=new busDAO();
		int buscap=busdao.getcap(busno);
		
		bookingDAO bookingdao=new bookingDAO();
		int bookcap=bookingdao.getbookcount(busno, date);
		
		return bookcap<buscap;
		
	}
	

}
