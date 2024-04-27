package edu.mu;

import edu.mu.Products.*;
import edu.mu.User.User;

public class BorrowSystem {
	private Library library;
	
	public BorrowSystem(Library library) {
		this.library=library;
	}

	public boolean borrowProduct(User user, String title, String author) {
		Product product = library.searchFor(title, author);
		if(product==null) {
			System.out.println("Product not found");
			return false;
		}
		if(library.isProductAvailable(product)) {
			library.checkOutProduct(user, product);
			product.setAvailable(false);
			System.out.println("You have checked out " + product.toString());
			return true;
		} else {
			System.out.println("Product is currently unavailable");
			return false;
		}
	}
	
	public boolean returnProduct(User user, String title, String author) {
		Product product = library.searchFor(title, author);
		if(product==null) {
			System.out.println("Product not found");
			return false;
		}
		if(library.isProductAvailable(product)) {
			library.returnProduct(user, product);
			product.setAvailable(true);
			System.out.println("Successfully returned " + product.toString());
			return true;
		} else {
			System.out.println("You have not borrowed this product.");
			return false;
		}
	}
}
