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
	private Product b = null;
	private Product c = null;
	private Product d = null;
	private Product g = null;
	private Product m = null;
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
	b=fact.createProduct("Jojo's", "Araki", ProductType.BOOK, ProductGenre.GRAPHIC_NOVEL);
	c=fact.createProduct("Oh, My Heart", "Mother Mother", ProductType.CD, ProductGenre.POP);
	d=fact.createProduct("Dude, Where's My Car?!", "Danny Leiner", ProductType.DVD, ProductGenre.SCI_FI);
	g=fact.createProduct("Lego Star Wars", "Travelers Tales", ProductType.GAME, ProductGenre.ADVENTURE);
	m=fact.createProduct("Tiger Beat", "Laufer Media", ProductType.MAGAZINE, ProductGenre.POP_CULTURE);
	lib=new Librarian("June", "librarianEmail@email.com");
//	library.addProductToCatalog(lib, c.getTitle(), c.getAuthor(), c.getType(), c.getGenre());
//	library.addProductToCatalog(lib, g.getTitle(), g.getAuthor(), g.getType(), g.getGenre());
//	library.addProductToCatalog(lib, d.getTitle(), d.getAuthor(), d.getType(), d.getGenre());
//	library.addProductToCatalog(lib, m.getTitle(), m.getAuthor(), m.getType(), m.getGenre());
	cust = new Customer("Albert","CustomerEmail@email.com");
	
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testLibAddProductToCatalog() {
		assertEquals(true,library.addProductToCatalog(lib, b.getTitle(), b.getAuthor(), b.getType(), b.getGenre()));
		assertEquals("June",lib.getName());
		assertEquals("librarianEmail@email.com",lib.getEmail());
		assertEquals(true,library.addProductToCatalog(lib, c.getTitle(), c.getAuthor(), c.getType(), c.getGenre()));
		assertEquals(true,library.addProductToCatalog(lib, g.getTitle(), g.getAuthor(), g.getType(), g.getGenre()));
		assertEquals(true,library.addProductToCatalog(lib, d.getTitle(), d.getAuthor(), d.getType(), d.getGenre()));
		assertEquals(true,library.addProductToCatalog(lib, m.getTitle(), m.getAuthor(), m.getType(), m.getGenre()));
		assertEquals(true,library.checkOutProduct(lib, b.getTitle(), b.getAuthor()));
		assertEquals(false,library.checkOutProduct(lib, g.getTitle(), m.getAuthor()));
		assertEquals(false,library.checkOutProduct(lib, b.getTitle(), b.getAuthor()));
		assertEquals(false,library.returnProduct(cust, b.getTitle(), b.getAuthor()));
		assertEquals(true,library.returnProduct(lib, b.getTitle(), b.getAuthor()));

	}
	@Test
	void testCustAddProductToCatalog() {
		assertEquals(false,library.addProductToCatalog(cust, b.getTitle(), b.getAuthor(), b.getType(), b.getGenre()));
		assertEquals("Albert",cust.getName());
		assertEquals("CustomerEmail@email.com",cust.getEmail());
		assertEquals(false,library.addProductToCatalog(cust, c.getTitle(), c.getAuthor(), c.getType(), c.getGenre()));
		assertEquals(false,library.addProductToCatalog(cust, g.getTitle(), g.getAuthor(), g.getType(), g.getGenre()));
		assertEquals(false,library.addProductToCatalog(cust, d.getTitle(), d.getAuthor(), d.getType(), d.getGenre()));
		assertEquals(false,library.addProductToCatalog(cust, m.getTitle(), m.getAuthor(), m.getType(), m.getGenre()));
	}
	
	@Test
	void testLibRemoveProductFromCatalog() {
		library.addProductToCatalog(lib, b.getTitle(), b.getAuthor(), b.getType(), b.getGenre());
		assertEquals(true,library.removeProductFromCatalog(lib, b.getTitle(), b.getAuthor(), b.getType(), b.getGenre()));
		assertEquals(false,library.removeProductFromCatalog(lib, g.getTitle(), b.getAuthor(), b.getType(), b.getGenre()));
	}
	
	@Test
	void testCustRemoveProductFromCatalog() {
		library.addProductToCatalog(lib, b.getTitle(), b.getAuthor(), b.getType(), b.getGenre());
		assertEquals(false,library.removeProductFromCatalog(cust, b.getTitle(), b.getAuthor(), b.getType(), b.getGenre()));
	}
	
	

}
