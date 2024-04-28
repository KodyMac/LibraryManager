package edu.mu;

import edu.mu.Products.*;
import edu.mu.User.*;

public class Main {

	public static void main(String[] args) {
		Library library = new Library();
//		//ProductFactory factory = new ProductFactory();
//		
		Customer cust = new Customer("Albert","CustomerEmail@email.com");
		Librarian lib = new Librarian("June", "librarianEmail@email.com");
		library.addProductToCatalog(cust, "The Golden Experience", "Prince", ProductType.CD, ProductGenre.POP); //should fail due to customer permission
		library.addProductToCatalog(lib, "The Golden Experience", "Prince", ProductType.CD, ProductGenre.POP); //should work
		library.addProductToCatalog(lib, "Jojo's Bizarre Adventure", "Hirohiko Araki", ProductType.BOOK, ProductGenre.GRAPHIC_NOVEL);
		library.addProductToCatalog(lib, "Shounen Jump", "Shuesha", ProductType.MAGAZINE, ProductGenre.POP_CULTURE);
		library.addProductToCatalog(lib, "Persona 3 Reload", "Atlus", ProductType.GAME, ProductGenre.ADVENTURE);
//		/*Generic?*/Book Jojo = factory.createProduct("Jojo's Bizarre Adventure", "Hirohiko Araki", ProductType.BOOK, ProductGenre.ADVENTURE)); 
//		//library.addProduct(cust, Jojo);//should fail
//		library.addProduct(lib, factory.createProduct("Jojo's Bizarre Adventure", "Hirohiko Araki", ProductType.BOOK, ProductGenre.ADVENTURE)); //should allow to add
//		library.addProduct(lib, factory.createProduct("The Complete Saga", "George Lucas", ProductType.CD,ProductGenre.SCI_FI));
//		library.addProduct(lib, factory.createProduct("Shonen Jump", "Shuesha", ProductType.MAGAZINE, ProductGenre.POP_CULTURE));
//		library.addProduct(lib, factory.createProduct("Persona 3 Reload", "Atlus", ProductType.GAME, ProductGenre.ADVENTURE));
//		library.addProduct(lib, factory.createProduct("If You Give A Mouse A Cookie", "Laura Numeroff", ProductType.BOOK, ProductGenre.CHILDREN));
//		
//		library.removeProduct(cust, null);

	}

}
