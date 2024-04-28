package edu.mu.Products;

public class ProductFactory {
	public Product createProduct(String title, String author, ProductType type, ProductGenre genre) {
		Product p = null;
		switch(type) {
		case BOOK:
			p = new Book(title, author, type, genre);
			p.available=true;
			break;
		case MAGAZINE:
			p = new Magazine(title, author, type, genre);
			p.available=true;
			break;
		case CD:
			p = new CD(title, author, type, genre);
			p.available=true;
			break;
		case DVD:
			p = new DVD(title, author, type, genre);
			p.available=true;
			break;
		case GAME:
			p = new Game(title, author, type, genre);
			p.available=true;
			break;
		default:
			return null;
		}
		return p;
	}
}
