package br.edu.ifsp.telescopio.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public void getConnection() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.getConnection("jdbc:mysql://telescopio.mysql.uhserver.com:80", "rsovat", "8lk12mop25me.");
			System.out.println("Conectando ao banco.");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
