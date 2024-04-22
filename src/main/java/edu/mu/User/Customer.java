package edu.mu.User;

public class Customer implements User{

	private String name;
	private String email;
	private Permissions permission = Permissions.CUSTOMER;
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public Permissions getPermissionType() {
		//System.out.println("You are a " + permission + "You are able to check out and return products and see what you have currently checked out");
		return permission;
	}

}
