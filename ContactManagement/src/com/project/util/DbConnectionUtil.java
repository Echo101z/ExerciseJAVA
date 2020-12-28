package com.project.util;
import java.sql.*;
public class DbConnectionUtil {
	
public static Connection getMySqlConnection() throws Exception {
		
		 Connection con = null;

	  // String fileName = "DbConnection.properties";
		
		try {		
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contact","kp","kp123");
			return con;
		} 
		catch ( SQLException e) {
			
			e.printStackTrace();
		}
		
		return con;
	}
	
}
