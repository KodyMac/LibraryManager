package edu.mu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.mu.Products.Product;
import edu.mu.Products.ProductFactory;
import edu.mu.Products.ProductGenre;
import edu.mu.Products.ProductType;
import edu.mu.User.Customer;
import edu.mu.User.Librarian;

class LibraryTest {

	Library library = new Library();
	ProductFactory fact = new ProductFactory();
	private Product p = null;
	private Librarian lib = null;
	private Customer cust = null;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	p=fact.createProduct("Jojo's", "Araki", ProductType.BOOK, ProductGenre.GRAPHIC_NOVEL);
	lib=new Librarian("June", "librarianEmail@email.com");
	cust = new Customer("Albert","CustomerEmail@email.com");
	
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCustAddProductToCatalog() {
		assertEquals(false,library.addProductToCatalog(cust, p.getTitle(), p.getAuthor(), p.getType(), p.getGenre()));
	}
	
	@Test
	void testLibAddProductToCatalog() {
		assertEquals(true,library.addProductToCatalog(cust, p.getTitle(), p.getAuthor(), p.getType(), p.getGenre()));
	}

}
