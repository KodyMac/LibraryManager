package model;

public class Customer extends User {
	public Customer(String name, String email) {
		super(name, email, PermissionType.CUSTOMER);
	}
}
