package edu.mu;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.mu.Products.*;
import edu.mu.User.Permissions;
import edu.mu.User.User;

public class Library {
	private List<Product> products;
	private Map<User, Map<List<Product>,LocalDate>> checkedOut; //list of checked out books, along with the User who checked it out and the dueDate

	public Library() {
		this.products = new ArrayList<>();
		this.checkedOut = new HashMap<>();
	}
	
	public void addProduct(User user, Product product) {
		if(user.getPermissionType()!= Permissions.LIBRARIAN) {
			System.out.println("You do not have the access to do that.\n");
			return;
		}
		products.add(product);
		System.out.println("Product of " + product.getType() + " type. " + product.getTitle() + " by " + product.getAuthor() + " has been added to the catalog.\n");
	}
	
	public void removeProduct(User user, Product product) {
		if(user.getPermissionType()!= Permissions.LIBRARIAN) {
			System.out.println("You do not have the access to do that. \n");
			return;
		}
		products.remove(product);    //will this work?
		System.out.println("Product of " + product.getType() + " type. " + product.getTitle() + " by " + product.getAuthor() + " has been removed from the catalog.\n");
	}
	
	//borrow and return methods
	
}
