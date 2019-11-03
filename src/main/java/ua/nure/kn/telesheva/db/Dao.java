package ua.nure.kn.telesheva.db;

import java.util.Collection;

public interface Dao<T> {

	Object result = null;

	T create(T entity) throws DatabaseException;
	
	void update(T entity) throws DatabaseException;
	
	void delete(T entity) throws DatabaseException;
	
	void find(long id) throws DatabaseException;
	
	Collection<T> findAll() throws DatabaseException;

	void setConnectionFactory(ConnectionFactory createConnection);
}
