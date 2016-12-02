package com.muthagroup.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionModel {
	static Connection con = null;

	public static Connection getConnection() {

		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/odk_prod", "root","root");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Connection Failed");
		}

		return con; // returns Connection

	} 
	public static Connection getERPConnection()
	{
		try{
		 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	     con = DriverManager.getConnection("jdbc:sqlserver://192.168.0.6:1433;databaseName=FOUNDRYERP;user=BWAYS;password=BWAYSKING321");	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
