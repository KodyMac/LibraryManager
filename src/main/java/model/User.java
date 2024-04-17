package model;

public class User {
	private String name;
	private String email;
	private PermissionType permissions;
	
	public User(String name, String email, PermissionType permissions) {
		this.name=name;
		this.email=email;
		this.permissions=permissions;
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public PermissionType getPermissions() {
		return permissions;
	}
	public void setPermissions(PermissionType permissions) {
		this.permissions = permissions;
	}
}
