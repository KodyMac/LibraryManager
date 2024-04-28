package edu.mu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.mu.Products.*;
import edu.mu.User.Permissions;
import edu.mu.User.User;

public class Library {
	private Map<User, List<Product>> checkedOut; //list of checked out products, along with the user who checked it out
	private List<Product> productCatalog; //list of all products
	private ProductFactory factory;
	
	public Library() {
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
	 * If the user has LIBRARIAN permission access, it will remove the product from the library catalog.
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
	/**
	 * Generic search function.
	 * @param title
	 * @param author
	 * @return Product
	 */
	public Product searchFor(String title, String author) {
		for (Product product : productCatalog) {
	        if (product.getTitle().equals(title) && product.getAuthor().equals(author)) {
	        	return product;
	        }
	    }
	    System.out.println("Product not found in the catalog.");
	    return null;
	}

	/**
	 * A search function for finding the exact product needed. Such as if multiple products titled the same.
	 * @param title
	 * @param author
	 * @param type
	 * @param genre
	 * @return Product
	 */
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

/**
 * Will check to see if a product is currently unavailable and is checked out by the user. If it is, it will return the product to the catalog and set availability to open.
 * @param user
 * @param product
 */
public void returnProduct(User user, Product product) {
	if(checkedOut.containsKey(user)) {
		List<Product> userChecked = checkedOut.get(user);
		if(userChecked.contains(product)) {
			userChecked.remove(product);
		}
	}
}
/**
 * Checks product availability.
 * @param product
 * @return
 */
public boolean isProductAvailable(Product product) {
	return product.isAvailable();
	}
}