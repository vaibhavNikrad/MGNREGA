package com.Utility;

import java.sql.*;

//This package provide the utilities such as connection 

public class DButil {

	public static Connection getConnection() throws SQLException {
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/demo";
		
		try {
			conn = DriverManager.getConnection(url, "root", "0000");
			
					} catch (SQLException e) {
						e.printStackTrace();
			
		}
		return conn;

	}
	
}
