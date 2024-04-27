package edu.mu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.mu.Products.*;
import edu.mu.User.Permissions;
import edu.mu.User.User;

public class Library {
	//private List<Product> products;
	private Map<User, List<Product>> /*Map<List<Product>,LocalDate>>*/ checkedOut; //list of checked out books, along with the User who checked it out and the dueDate
	private List<Product> productCatalog;
	private ProductFactory factory;
	
	public Library() {
		//this.products = new ArrayList<>();
		this.checkedOut = new HashMap<>();
		this.productCatalog = new ArrayList<Product>();
		this.factory = new ProductFactory();
	}
	
	/**
	 * If the user has LIBRARIAN permission access, it will create add a product to the catalog
	 * @param user
	 * @param product
	 */
	public boolean addProductToCatalog(User user, String title, String author, ProductType type, ProductGenre genre) {
		if(user.getPermissionType() != Permissions.LIBRARIAN) {
			System.out.println("You do not have access to do that.\n");
			return false;
		}
		if(productCatalog.add(factory.createProduct(title, author, type, genre))) {
			System.out.println("Product of " + type + " type. " + title + " by " + author + " has been added to the catalog.\n");
			return true;
		} else {
			System.out.println("Something went wrong. Make sure the information is correct.");
			return false;
		}
	}
	
	/**
	 * If the user is has LIBRARIAN permission access, it will remove the product from the library catalog.
	 * @param user
	 * @param product
	 */
	public boolean removeProductFromLibrary(User user, String title, String author, ProductType type, ProductGenre genre) {
		Product product = searchForAdmin(title,author,type,genre);
		if(user.getPermissionType() != Permissions.LIBRARIAN) {
			System.out.println("You do not have access to do that. \n");
			return false;
		}
		if(productCatalog.contains(product)) {
			productCatalog.remove(product);
			System.out.println("Product of " + product.getType() + " type. " + product.getTitle() + " by " + product.getAuthor() + " has been removed from the catalog.\n");
			return true;
		} else return false;
	}
	
	public Product searchFor(String title, String author) {
		for (Product product : productCatalog) {
	        if (product.getTitle().equals(title) && product.getAuthor().equals(author)) {
	        	return product;
	        }
	    }
	    System.out.println("Product not found in the catalog.");
	    return null;
	}

	
	public Product searchForAdmin(String title, String author, ProductType type, ProductGenre genre) {
		for (Product product : productCatalog) {
	        if (product.getTitle().equals(title) && product.getAuthor().equals(author) && product.getType().equals(type) && product.getGenre().equals(genre)) {
	        	return product;
	        }
	    }
	    System.out.println("Product not found in the catalog.");
	    return null;
	}
	/**
	 * Will check to see if the product is currently available. If it is, it will "check out" the product under the user's account.
	 * @param user
	 * @param product
	 */
public void checkOutProduct(User user, Product product) {
	if(!checkedOut.containsKey(user)) {
		checkedOut.put(user, new ArrayList<>());
	}
		checkedOut.get(user).add(product);
		return;
}

public void returnProduct(User user, Product product) {
	if(checkedOut.containsKey(user)) {
		List<Product> userChecked = checkedOut.get(user);
		if(userChecked.contains(product)) {
			userChecked.remove(product);
		}
	}
}

public boolean isProductAvailable(Product product) {
	return product.isAvailable();
}
	




}
	
//		if(!product.isAvailable()) {
//			System.out.println("Sorry, this " + product.getType()  + " is not currently available");
//		}
//		List<Product> userCheckedOut = checkedOut.get(user); //?
//		userCheckedOut.add(product);
//		checkedOut.put(user, userCheckedOut);
//		product.setAvailable(false);
//		System.out.println(product.getTitle() + " by " + product.getAuthor() + " has been checked out by " + user.getName());
//	}
//	/**
//	 * Will check if the product has been taken out by the user, and if it has, it will return the product to the library. Setting it's
//	 * availability back to true.
//	 * @param user
//	 * @param product
//	 */
//	public void returnProduct(User user, Product product) {
//		List<Product> userProduct=checkedOut.get(user);
//		if(userProduct==null || !userProduct.contains(product)) {
//			System.out.println("The product was not checked out by " + user.getName());
//			return;
//		}
//		
//		userProduct.remove(product);
//		checkedOut.put(user, userProduct);
//		product.setAvailable(true);
//		System.out.println("Product \"" + product.getTitle() + "\" has been returned by " + user.getName());
//	}
//	
//}
