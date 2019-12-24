package ua.nure.kn.telesheva.agent;

import ua.nure.kn.telesheva.db.DatabaseException;

public class SearchException extends Exception {
	
	public SearchException(DatabaseException e) {
		// TODO Auto-generated constructor stub
		e.printStackTrace();
	}

}
