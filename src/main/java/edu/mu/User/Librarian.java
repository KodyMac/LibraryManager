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
		return permission;
	}

}
