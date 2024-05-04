package edu.mu.Products;

public class Magazine extends Product {
	public Magazine(String title, String author, ProductType type, ProductGenre genre) {
		super(title, author, type, /*ID,*/ genre);
	}
}