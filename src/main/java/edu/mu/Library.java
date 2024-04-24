package edu.mu;

//import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.mu.Products.*;
import edu.mu.User.Permissions;
import edu.mu.User.User;

public class Library {
	private List<Product> products;
	private Map<User, List<Product>> /*Map<List<Product>,LocalDate>>*/ checkedOut; //list of checked out books, along with the User who checked it out and the dueDate

	public Library() {
		this.products = new ArrayList<>();
		this.checkedOut = new HashMap<>();
	}
	/**
	 * If the user has LIBRARIAN permission access, it will create add a product to the catalog
	 * @param user
	 * @param product
	 */
	public void addProduct(User user, Product product) {
		if(user.getPermissionType()!= Permissions.LIBRARIAN) {
			System.out.println("You do not have the access to do that.\n");
			return;
		}
		products.add(product);
		System.out.println("Product of " + product.getType() + " type. " + product.getTitle() + " by " + product.getAuthor() + " has been added to the catalog.\n");
	}
	/**
	 * If the user is has LIBRARIAN permission access, it will remove the product from the library catalog.
	 * @param user
	 * @param product
	 */
	public void removeProduct(User user, Product product) {
		if(user.getPermissionType()!= Permissions.LIBRARIAN) {
			System.out.println("You do not have the access to do that. \n");
			return;
		}
		products.remove(product);    //will this work?
		System.out.println("Product of " + product.getType() + " type. " + product.getTitle() + " by " + product.getAuthor() + " has been removed from the catalog.\n");
	}
	/**
	 * Will check to see if the product is currently available. If it is, it will "check out" the product under the user's account.
	 * @param user
	 * @param product
	 */
	public void borrowProduct(User user, Product product) {
		if(!product.isAvailable()) {
			System.out.println("Sorry, this " + product.getType()  + " is not currently available");
		}
		List<Product> userCheckedOut = checkedOut.get(user); //?
		userCheckedOut.add(product);
		checkedOut.put(user, userCheckedOut);
		product.setAvailable(false);
		System.out.println(product.getTitle() + " by " + product.getAuthor() + " has been checked out by " + user.getName());
	}
	/**
	 * Will check if the product has been taken out by the user, and if it has, it will return the product to the library. Setting it's
	 * availability back to true.
	 * @param user
	 * @param product
	 */
	public void returnProduct(User user, Product product) {
		List<Product> userProduct=checkedOut.get(user);
		if(userProduct==null || !userProduct.contains(product)) {
			System.out.println("The product was not checked out by " + user.getName());
			return;
		}
		
		userProduct.remove(product);
		checkedOut.put(user, userProduct);
		product.setAvailable(true);
		System.out.println("Product \"" + product.getTitle() + "\" has been returned by " + user.getName());
	}
	
}
