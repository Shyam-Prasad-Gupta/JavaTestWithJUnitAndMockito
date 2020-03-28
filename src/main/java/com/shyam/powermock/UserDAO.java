package com.shyam.powermock;

public class UserDAO {

	public int createUser(User user) {
		int id = IDGenerator.generateId();
		user.setId(id);
		// code to save the user into the DB goes here
		return id;
	}

}
