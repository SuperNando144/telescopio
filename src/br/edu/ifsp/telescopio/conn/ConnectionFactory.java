package br.edu.ifsp.telescopio.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() throws ClassNotFoundException {
		try {
			return DriverManager.getConnection("jdbc:mysql://telescopio.mysql.uhserver.com/telescopio", "rsovat", "8lk12mop25me.");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/*
			DriverManager.getConnection("jdbc:mysql://telescopio.mysql.uhserver.com/telescopio", "rsovat", "8lk12mop25me.");	
			DriverManager.getConnection("jdbc:mysql://localhost/telescopio", "root", "");
			
			DriverManager.getConnection("jdbc:mysql://telescopio.c5nk8d7lhqjn.us-east-2.rds.amazonaws.com:3306/telescopio", "fernando", "8lk12mop25me.");
	*/
}
