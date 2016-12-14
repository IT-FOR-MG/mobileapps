package connmodel;

import java.sql.Connection;
import java.sql.DriverManager;

//============================================================================-->
//==================== Database Connection Model =============================-->
//============================================================================-->

public class Connection_Utility {

	static Connection con = null;

	public static Connection getConnection() { 
		try { 
			//loads the driver class 			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://192.168.0.7:3306/complaintzilla", "root","root"); 
			//System.out.println("Connection Estab"); 
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Connection Failed");
		} 
		return con; // returns Connection 
	} 
}
