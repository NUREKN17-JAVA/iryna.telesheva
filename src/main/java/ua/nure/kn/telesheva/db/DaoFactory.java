package ua.nure.kn.telesheva.db;

import java.io.IOException;
import java.util.Properties;

public class DaoFactory {
	private static final String USER = "connection.user";
	private static final String PASSWORD = "connection.password";
	private static final String URL = "connection.url";
	private static final String DRIVER = "connection.driver";
	private static final String USER_DAO = "dao.UserDao";

	private final Properties properties;
	
	  private final static DaoFactory INSTANCE = new DaoFactory();
	    
	    public static DaoFactory getInstance() {
	        return INSTANCE;
	    }

	public DaoFactory() {
		this.properties = new Properties();
		try {
			properties.load(getClass().getClassLoader().getResourceAsStream("settings.properties"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private ConnectionFactory createConnection() {
		String user = properties.getProperty(USER);
		String password = properties.getProperty(PASSWORD);
		String url = properties.getProperty(URL);
		String driver = properties.getProperty(DRIVER);

		return new ConnectionFactoryImpl(user, password, url, driver);
	}

	public Dao getUserDao() throws ReflectiveOperationException { 
		Dao result = null; 
		try {
			Class hsqlUserDaoClass = Class.forName(properties.getProperty(USER_DAO));
			result = (Dao) hsqlUserDaoClass.newInstance();
			result.setConnectionFactory(createConnection());
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            throw new ReflectiveOperationException(e);
        }
		return result;
	}

}
