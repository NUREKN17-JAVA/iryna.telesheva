package ua.nure.kn.telesheva.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactoryImpl implements ConnectionFactory {

	private final String user;
	private final String password;
	private final String url;
	private final String driver;

	public ConnectionFactoryImpl(String user, String password, String url, String driver) {
		this.user = user;
		this.password = password;
		this.url = url;
		this.driver = driver;
	}

	@Override
	public Connection getConnection() throws DatabaseException {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new DatabaseException(e);
		}
		
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
	}


}
