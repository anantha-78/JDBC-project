package com.Tap.Connect;

import java.sql.Connection;
import java.sql.DriverManager;
public class MyConnection {
	
	static final String URL = "jdbc:mysql://localhost:3306/company2024"; 
	static final String USERNAME = "root";
	static final String PASSWORD = "Anandsri@1008";
	
	private MyConnection(){
		
	}
	
	static private MyConnection connection = new MyConnection();
	
	public static MyConnection getMyConnection(){
		return connection;
	}
	
	public static Connection connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
