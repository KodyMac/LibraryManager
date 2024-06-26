package edu.mu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import edu.mu.Products.*;
import edu.mu.User.User;

public class BorrowSystem {
	private Library library;
	private Map<User, List<Product>> checkedOut; //list of checked out products, along with the user who checked it out
	
	public BorrowSystem(Library library) {
		this.library=library;
		this.checkedOut = new HashMap<>();
	}

	
	public boolean borrowProduct(User user, String title, String author) {
		if(!checkedOut.containsKey(user)) {			//create new user checkedOut log
			checkedOut.put(user, new ArrayList<>());
		}
		
		Product product = library.searchFor(title, author);   //search for requested product
		if(product!=null) {  //product is found and is available
			if(library.isProductAvailable(product) ) {
				product.setAvailable(false);
				List<Product> temp=checkedOut.get(user);
				temp.add(product);
				checkedOut.put(user, temp);
				System.out.println(user.getName() + " has checked out " + product.getTitle() + " by " + product.getAuthor() + "\n");
				return true;
			}
			if(!library.isProductAvailable(product) ) { //product is not available
				System.out.println("Product is currently unavailable\n");
				return false;
			}
		}									
		System.out.println("Product not found");
		return false;
}
	
	
	
	public boolean returnProduct(User user, String title, String author) {
		Product product = library.searchFor(title, author);
		if(product != null) {
			List<Product> temp=checkedOut.get(user);
			if(!temp.contains(product)) { //user has not checked out this product
				System.out.println("You have not borrowed this product.\n");
				return false;
			}
			if(temp.contains(product)) { //if the user has checked it out
				checkedOut.get(user).remove(product);
				product.setAvailable(true);
				System.out.println(user.getName() + " has successfully returned " + product.getTitle() + " by " + product.getAuthor()+ "\n");
				return true; 
			}
		}
		System.out.println("Product not found.\n");
		return false;
	}
}
