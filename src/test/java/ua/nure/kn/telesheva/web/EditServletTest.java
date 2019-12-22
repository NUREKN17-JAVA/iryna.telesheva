package ua.nure.kn.telesheva.web;

import java.text.DateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.nure.kn.telesheva.usermanagement.User;

class EditServletTest extends MockServletTestCase {
	
	private static final String FIRST_NAME = "John";
	private static final String LAST_NAME = "Doe";
	private static final String ID_VALUE = "1000";

	@BeforeEach
	protected void setUp() throws Exception {
		super.setUp();
		createServlet(EditServlet.class);
	}
	
	public void testEdit() {
		Date date = new Date();
		User user = new User(new Long(1000), "John", "Doe", date);
		
		addRequestParameter("id", ID_VALUE);
		addRequestParameter("firstName", FIRST_NAME);
		addRequestParameter("lastName", LAST_NAME);
		addRequestParameter("date", DateFormat.getInstance().format(date));
		addRequestParameter("okButton", "Ok");
		doPost();
	}

	@Test
	void test() {
		
	}

}
