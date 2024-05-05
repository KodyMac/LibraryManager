package edu.mu;

import java.util.ArrayList;
//import edu.mu.BorrowSystem;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

import edu.mu.Products.*;
import edu.mu.User.Permissions;
import edu.mu.User.User;

public class Library {
	//private Map<User, List<Product>> checkedOut; //list of checked out products, along with the user who checked it out
	private List<Product> productCatalog; //list of all products
	private ProductFactory factory;
	private BorrowSystem borrower;
	
	public Library() {
		//this.checkedOut = new HashMap<>();
		this.productCatalog = new ArrayList<Product>();
		this.factory = new ProductFactory();
		this.borrower = new BorrowSystem(this);
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
	public boolean removeProductFromCatalog(User user, String title, String author, ProductType type, ProductGenre genre) {
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
	private Product searchForAdmin(String title, String author, ProductType type, ProductGenre genre) {
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
public boolean checkOutProduct(User user, String title, String author) {  //carries along the parameters to the borrowing system
		return borrower.borrowProduct(user, title, author);
}

/**
 * Will check to see if a product is currently unavailable and is checked out by the user. If it is, it will return the product to the catalog and set availability to open.
 * @param user
 * @param product
 */
public boolean returnProduct(User user, String title, String author) {
	return borrower.returnProduct(user, title, author);
}
/**
 * Checks product availability.
 * @param product
 * @return
 */
public boolean isProductAvailable(Product product) {
	return product.isAvailable();
	}

/**
 * Prints entire catalog
 */
public void showCatalog() {
	for(Product product : productCatalog) {
		System.out.println(product.getTitle() + " by " + product.getAuthor() + ", A " + product.getType() + ". Genre: " + product.getGenre() + " \tAvailable: " + product.isAvailable());
	}
}

/**
 * Print out products by given ProductType
 * @param type
 */
public void typeSearch(ProductType type) {
	for(Product product : productCatalog) {
		if(product.getType()==type) {
			System.out.println(product.getTitle() + " by " + product.getAuthor() + ", A " + product.getType() + ". Genre: " + product.getGenre());
		}
	}
	System.out.println("\n");
}

/**
 * Print out products by given genre
 * @param genre
 */
public void genreSearch(ProductGenre genre) {
	for(Product product : productCatalog) {
		if(product.getGenre()==genre) {
			System.out.println(product.getTitle() + " by " + product.getAuthor() + ", A " + product.getType() + ". Genre: " + product.getGenre());
		}
	}
	System.out.println("\n");
}

/**
 * Print out products by given author
 * @param author
 */
public void authorSearch(String author) {
	for(Product product : productCatalog) {
		if(product.getAuthor()==author) {
			System.out.println(product.getTitle() + " by " + product.getAuthor() + ", A " + product.getType() + ". Genre: " + product.getGenre());
		}
	}
	System.out.println("\n");
}

}