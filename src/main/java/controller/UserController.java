package controller;

import model.User;
import view.UserView;

public class UserController {
	private User model;
	private UserView view;
	
	public UserController(User model, UserView view) {
		this.model=model;
		this.view=view;
	}

	public void updateUser(String name, String email) {
		model.setEmail(email);
		model.setName(name);
	}
	
	public void displayUserInfo() {
		
	}
	
	
}
