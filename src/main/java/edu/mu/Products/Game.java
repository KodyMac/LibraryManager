package edu.mu.Products;

public class Game extends Product {
	public Game(String title, String author, ProductType type, ProductGenre genre) {
		super(title, author, type, /*ID,*/ genre);
	}
}