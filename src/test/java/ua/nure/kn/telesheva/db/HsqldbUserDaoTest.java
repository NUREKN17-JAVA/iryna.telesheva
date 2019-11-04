package ua.nure.kn.telesheva.db;

import java.util.Calendar;
import java.util.Collection;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.XmlDataSet;

import ua.nure.kn.telesheva.usermanagement.User;
import ua.nure.kn.telesheva.db.HsqldbUserDao;

public class HsqldbUserDaoTest extends DatabaseTestCase {

	private HsqldbUserDao dao; // этот объект будет поддерживать соединение с БД
	private ConnectionFactory connectionFactory;
	private static final int DAY_OF_BIRTH = 1;
	private static final int MONTH = 1;
	private static final int YEAR = 2010;
	private static final String LAST_NAME = "Gates";
	private static final String FIRST_NAME = "Bill";
	   private static final long ID = 1L;
	
    private User createUserWithoutID() {
        User user = new User(null, FIRST_NAME, LAST_NAME, new Date());
        return user;
    }

    private User createUserWithID() {
        User user = new User(ID, FIRST_NAME, LAST_NAME, new Date());
        return user;
    }

	public void testCreate() throws DatabaseException {
		User user = new User();
		user.setFirstName(FIRST_NAME);
		user.setLastName(LAST_NAME);
		Calendar calendar = Calendar.getInstance();
		calendar.set(YEAR, MONTH, DAY_OF_BIRTH);
		user.setDateOfBirth(calendar.getTime());
		assertNull(user.getId());
		User userToCheck = dao.create(user);
		assertNotNull(userToCheck);
		assertNotNull(userToCheck.getId());
		assertEquals(FIRST_NAME, userToCheck.getFirstName());
		assertEquals(LAST_NAME, userToCheck.getLastName());
		assertEquals(calendar.getTime(), userToCheck.getDateOfBirth());
	}
	
	/*
	 * public void testFind() throws DataBaseException {
	 * hsqldbUserDao.create(createUserWithID()); User testUser =
	 * hsqldbUserDao.find(ID); assertNotNull(testUser);
	 * assertEquals(testUser.getFirstName(), user.getFirstName());
	 * assertEquals(testUser.getLastName(), user.getLastName()); }
	 * 
	 * public void testDelete() throws DataBaseException { User testUser =
	 * createUserWithID(); hsqldbUserDao.delete(testUser);
	 * assertNull(hsqldbUserDao.find(ID)); }
	 * 
	 * public void testUpdate() throws DataBaseException { String testFirstName =
	 * "Sam"; String testLastName = "Smith"; Date testDateOfBirth = new Date(); User
	 * testUser = new User(1L, testFirstName, testLastName, testDateOfBirth);
	 * HsqldbUserDao.create(testUser);
	 * 
	 * testUser.setFirstName("Sam11");
	 * 
	 * HsqldbUserDao.update(testUser); User updatedUser =
	 * hsqldbUserDao.find(testUser.getId()); assertNotNull(updatedUser);
	 * assertEquals(testUser.getFirstName(), updatedUser.getFirstName());
	 * assertEquals(testUser.getLastName(), updatedUser.getLastName()); }
	 */

	public void testFindAll() throws DatabaseException {
		Collection<User> items = dao.findAll();
		assertNotNull(items);
		assertEquals(2, items.size());
	}

	protected void setUp() throws Exception {
		super.setUp();
		dao = new HsqldbUserDao(connectionFactory);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		IDataSet dataSet = new XmlDataSet(getClass().getClassLoader().getResourceAsStream("usersDataSet.xml"));
		return dataSet;
	}

	@Override
	protected IDatabaseConnection getConnection() throws Exception {
		return new DatabaseConnection(connectionFactory.getConnection());
	}

}
