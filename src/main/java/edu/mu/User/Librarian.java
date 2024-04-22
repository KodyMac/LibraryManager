package edu.mu.User;

public class Librarian implements User{
	
	private String name;
	private String email;
	private Permissions permission = Permissions.LIBRARIAN;
	
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
		//System.out.println("You are a " + permission + ". You are able to add/remove products, add/remove users, look at all\nchecked out products and everything customers can do");
		return permission;
	}

}
