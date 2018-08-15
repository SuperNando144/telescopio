package br.edu.ifsp.telescopio.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://telescopio.mysql.uhserver.com", "rsovat", "8lk12mop25me.");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
