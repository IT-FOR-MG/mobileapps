package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionModel {
	static Connection con1 = null;
	static Connection con2 = null;
	public static Connection getConnection1() {


		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/odk_prod", "root","root");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Connection Failed");
		}

		return con1; // returns Connection

	} 
	public static Connection getConnection2() {


		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	         String connectionUrl = "jdbc:sqlserver://192.168.0.72:42612;" +
	                                 "database=ENGERP;" +
	                                 "user=UDAY;" +
	                                 "password=UDAY123";
	          con2 = DriverManager.getConnection(connectionUrl);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Connection Failed");
		}

		return con2; // returns Connection

	} 

}
