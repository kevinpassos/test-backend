package br.com.test.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static Connection connection;
	
	public static Connection getConnection() {
		if (connection == null) {
	        try {
	        	connection = DriverManager.getConnection("jdbc:mysql://localhost/cliente", "root", "");
	        } catch (SQLException e) {
	        	e.printStackTrace();
	            throw new RuntimeException(e);
	        }
		}
		
		return connection;
	}
	
}
