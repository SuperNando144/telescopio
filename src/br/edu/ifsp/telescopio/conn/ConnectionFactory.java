package br.edu.ifsp.telescopio.conn;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public void getConnection() throws ClassNotFoundException {
		try {
			 
			DriverManager.getConnection("jdbc:mysql://telescopio.mysql.uhserver.com/telescopio", "rsovat", "8lk12mop25me.");
			System.out.println("banco conectado");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/*
			DriverManager.getConnection("jdbc:mysql://telescopio.mysql.uhserver.com/telescopio", "rsovat", "8lk12mop25me.");	
			DriverManager.getConnection("jdbc:mysql://localhost/telescopio", "root", "");
	*/
}
