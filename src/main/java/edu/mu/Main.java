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
		library.addProductToCatalog(lib, "Jojo's Bizarre Adventure", "Hirohiko Araki", ProductType.BOOK, ProductGenre.GRAPHIC_NOVEL); //add to catalog
		library.addProductToCatalog(lib, "Shounen Jump", "Shuesha", ProductType.MAGAZINE, ProductGenre.POP_CULTURE); //add to catalog
		library.addProductToCatalog(lib, "Persona 3 Reload", "Atlus", ProductType.GAME, ProductGenre.ADVENTURE); //add to catalog
		library.addProductToCatalog(lib, "Dude, Where's My Car?!", "Danny Leiner", ProductType.DVD, ProductGenre.SCI_FI); //add to catalog
		library.checkOutProduct(cust, "Jojo's Bizarre Adventure", "Hirohiko Araki"); //customer check out
		library.checkOutProduct(lib, "Jojo's Bizarre Adventure", "Hirohiko Araki"); //fails, as it is already checked out
		library.authorSearch("Prince"); //search for products with author "Prince"
		library.searchFor("Fake", "Not Real");  //search for something not in catalog
		library.removeProductFromCatalog(lib,"Jojo's Bizarre Adventure", "Hirohiko Araki", ProductType.BOOK, ProductGenre.GRAPHIC_NOVEL); //fail to remove product already checked out
		library.showCatalog(); //print all of catalog
		library.returnProduct(cust, "Jojo's Bizarre Adventure", "Hirohiko Araki"); //return product
		library.removeProductFromCatalog(lib, "Jojo's Bizarre Adventure", "Hirohiko Araki", ProductType.BOOK, ProductGenre.GRAPHIC_NOVEL); //remove product
	}

}
