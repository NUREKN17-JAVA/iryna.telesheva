package ua.nure.kn.telesheva.web;

import java.text.DateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.nure.kn.telesheva.usermanagement.User;

class EditServletTest extends MockServletTestCase {
	
	private static final String ERROR_ATTRIBUTE = "error";
	private static final String OK_BUTTON = "Ok";
	private static final String OK_BUTTON_PARAMETER = "okButton";
	private static final String DATE_PARAMETER = "date";
	private static final String LAST_NAME_PARAMETER = "lastName";
	private static final String FIRST_NAME_PARAMETER = "firstName";
	private static final String ID_VALUE = "1000";
	private static final String ID_PARAMETER = "id";
	private static final String UPDATE_QUERY = "update";
	private static final String LAST_NAME = "Doe";
	private static final String FIRST_NAME = "John";

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
	
	public void testEditEmptyFirstName() {
		Date date = new Date();
		addRequestParameter(ID_PARAMETER, ID_VALUE);
		addRequestParameter(LAST_NAME_PARAMETER, LAST_NAME);
		addRequestParameter(DATE_PARAMETER, DateFormat.getInstance().format(date));
		addRequestParameter(OK_BUTTON_PARAMETER, OK_BUTTON);
		doPost();
		String errorMessage = (String)getWebMockObjectFactory().getMockRequest().getAttribute(ERROR_ATTRIBUTE);
		assertNotNull("Could not find error message in session scope", errorMessage);
	}
	
	public void testEditEmptyLastName() {
		Date date = new Date();
		addRequestParameter(ID_PARAMETER, ID_VALUE);
		addRequestParameter(FIRST_NAME_PARAMETER, FIRST_NAME);
		addRequestParameter(DATE_PARAMETER, DateFormat.getInstance().format(date));
		addRequestParameter(OK_BUTTON_PARAMETER, OK_BUTTON);
		doPost();
		String errorMessage = (String)getWebMockObjectFactory().getMockRequest().getAttribute(ERROR_ATTRIBUTE);
		assertNotNull("Could not find error message in session scope", errorMessage);
	}
	
	public void testEditEmptyDate() {
		Date date = new Date();
		addRequestParameter(ID_PARAMETER, ID_VALUE);
		addRequestParameter(FIRST_NAME_PARAMETER, FIRST_NAME);
		addRequestParameter(LAST_NAME_PARAMETER, LAST_NAME);
		addRequestParameter(OK_BUTTON_PARAMETER, OK_BUTTON);
		doPost();
		String errorMessage = (String)getWebMockObjectFactory().getMockRequest().getAttribute(ERROR_ATTRIBUTE);
		assertNotNull("Could not find error message in session scope", errorMessage);
	}
	
	public void testEditEmptyDateIncorrect() {
		Date date = new Date();
		addRequestParameter(ID_PARAMETER, ID_VALUE);
		addRequestParameter(FIRST_NAME_PARAMETER, FIRST_NAME);
		addRequestParameter(LAST_NAME_PARAMETER, LAST_NAME);
		addRequestParameter(DATE_PARAMETER, "lkjghdsfkhdfkjghfdl");
		addRequestParameter(OK_BUTTON_PARAMETER, OK_BUTTON);
		doPost();
		String errorMessage = (String)getWebMockObjectFactory().getMockRequest().getAttribute(ERROR_ATTRIBUTE);
		assertNotNull("Could not find error message in session scope", errorMessage);
	}

	@Test
	void test() {
		
	}

}
