package BusResvProject;
import java.sql.*;

public class Dbconnection {
	    private static String url="jdbc:mysql://localhost:3306/BusTicketReservation";
	    private static String userName="root";
	    private static String password="vijayanand97";
        
	    public static Connection dbconnector() throws SQLException{
        	 Connection con=DriverManager.getConnection(url, userName, password);
        	 return con;
         }
}
