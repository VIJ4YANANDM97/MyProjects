package BusResvProject;
import java.sql.*;
public class busDAO {
         public void displayBusInfo() throws SQLException {
        	 String query="select * from bus;";
        	 Connection con = Dbconnection.dbconnector();
        	 Statement sta=con.createStatement();
        	 ResultSet res=sta.executeQuery(query);
        	 
        	 while(res.next()) {
        		 System.out.println("Bus Number: "+ res.getInt(1));
        		 System.out.println("Bus capacity: "+ res.getInt(2));
        		 if(res.getInt(3)==1)
        		 {
        			 System.out.println("Type:Ac"+'\n');
        		 }
        		 else
        			 System.out.println("Type:Non-Ac"+'\n');
        		 
        	 }
        	 System.out.println("-------------------------------------");
         }
         
         public int getcap(int id) throws SQLException {
        	 
        	 String query="select capacity from BUS WHERE busNo= "+id;
        	 Connection con=Dbconnection.dbconnector();
        	 Statement sta=con.createStatement();
        	 ResultSet res=sta.executeQuery(query);
        	 res.next();
        	 return res.getInt(1);
         }
}
