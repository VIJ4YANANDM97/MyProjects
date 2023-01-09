package BusResvProject;
import java.sql.*;
import java.util.Date;


public class bookingDAO {
              
	public int getbookcount(int no, Date date) throws SQLException{
		
		String query="select count(Passanger_name) from BOOKING WHERE Bus_number=? and Date=?;";
		Connection con=Dbconnection.dbconnector();
		PreparedStatement Sta=con.prepareStatement(query);
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
		Sta.setInt(1, no);
		Sta.setDate(2, sqlDate);
		ResultSet res= Sta.executeQuery();
		res.next();
	    return res.getInt(1);
	
	}
	
	public void addtoTable(booking book) throws SQLException
	{
		Connection con=Dbconnection.dbconnector();
		String query="insert into BOOKING values(?,?,?);";
		PreparedStatement sta=con.prepareStatement(query);
		
		java.sql.Date sqlDate = new java.sql.Date(book.date.getTime());
		sta.setString(1, book.name);
		sta.setInt(2, book.busno);
		sta.setDate(3,sqlDate);
		
		sta.executeUpdate();
	}
}
