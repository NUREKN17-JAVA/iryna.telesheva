package ua.nure.kn.telesheva.db;

import java.sql.Connection;

public interface ConnectionFactory {
	Connection getConnection() throws DatabaseException;
}
