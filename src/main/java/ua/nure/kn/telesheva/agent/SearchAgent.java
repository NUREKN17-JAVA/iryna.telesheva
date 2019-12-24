package ua.nure.kn.telesheva.agent;

import java.util.Collection;

import jade.core.AID;
import jade.core.Agent;
import ua.nure.kn.telesheva.db.DaoFactory;
import ua.nure.kn.telesheva.db.DatabaseException;

public class SearchAgent extends Agent {
	
	protected void setup() {
		super.setup();
		System.out.println(getAID().getName() + " started!");
	}
	
	protected void takeDown() {
		super.takeDown();
		System.out.println(getAID().getName() + " terminated!");
	}
	
	public void search(String firstName, String lastName) throws SearchException {
		try {
			Collection users = DaoFactory.getInstance().getUserDao().find(firstName, lastName);
			if (users.size() > 0) {
				showUsers(users);
			} else {
				addBehaviour(new SearchRequestBehaviour(new AID[] (), firstName, lastName));
			}
		} catch (DatabaseException e) {
			throw new SearchException(e);
		}
	}

	private void showUsers(Collection users) {
		// TODO Auto-generated method stub
		
	}

}
