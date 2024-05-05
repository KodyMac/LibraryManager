package edu.mu;

import edu.mu.Products.*;
import edu.mu.User.*;

public class Main {

	public static void main(String[] args) {
		Library library = new Library();
		Customer cust = new Customer("Albert","CustomerEmail@email.com");
		Librarian lib = new Librarian("June", "librarianEmail@email.com");
		
		library.addProductToCatalog(cust, "The Golden Experience", "Prince", ProductType.CD, ProductGenre.POP); //should fail due to customer permission
		library.addProductToCatalog(lib, "The Golden Experience", "Prince", ProductType.CD, ProductGenre.POP); //should work
		library.addProductToCatalog(lib, "Jojo's Bizarre Adventure", "Hirohiko Araki", ProductType.BOOK, ProductGenre.GRAPHIC_NOVEL);
		library.addProductToCatalog(lib, "Shounen Jump", "Shuesha", ProductType.MAGAZINE, ProductGenre.POP_CULTURE);
		library.addProductToCatalog(lib, "Persona 3 Reload", "Atlus", ProductType.GAME, ProductGenre.ADVENTURE);
		library.checkOutProduct(cust, "Jojo's Bizarre Adventure", "Hirohiko Araki");
		library.checkOutProduct(lib, "Jojo's Bizarre Adventure", "Hirohiko Araki");
		library.authorSearch("Prince");
		library.showCatalog();
		library.returnProduct(cust, "Jojo's Bizarre Adventure", "Hirohiko Araki");
		//library.checkOutProduct(cust, library.searchFor("Jojo's Bizarre Adventure", "Hirohiko Araki"));
		
	}

}
