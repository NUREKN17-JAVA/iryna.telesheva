package ua.nure.kn.telesheva.db;

import java.util.Collection;

import ua.nure.kn.telesheva.usermanagement.User;

public interface Dao<T> {

	Object result = null;

	User create(User user) throws DatabaseException;
	
	void update(User user) throws DatabaseException;
	
	void delete(User user) throws DatabaseException;
	
	void find(long id) throws DatabaseException;
	
	Collection<T> findAll() throws DatabaseException;

	void setConnectionFactory(ConnectionFactory createConnection);
}
