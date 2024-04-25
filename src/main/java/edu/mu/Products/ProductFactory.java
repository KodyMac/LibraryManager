package edu.mu.Products;

public class ProductFactory {
	public Product /*to be generic*/ createProduct(String title, String author, ProductType type, /*String ID,*/ ProductGenre genre) {
		Product p = null;
		switch(type) {
		case BOOK:
			p = new Book(title, author, type, /*ID,*/ genre);
			p.available=true;
			break;
		case MAGAZINE:
			p = new Magazine(title, author, type, /*ID,*/ genre);
			p.available=true;
			break;
		case CD:
			p = new CD(title, author, type, /*ID,*/ genre);
			p.available=true;
			break;
		case DVD:
			p = new DVD(title, author, type, /*ID,*/ genre);
			p.available=true;
			break;
		case GAME:
			p = new Game(title, author, type, /*ID,*/ genre);
			p.available=true;
			break;
		default:
			return null;
		}
		return p;
	}
}
