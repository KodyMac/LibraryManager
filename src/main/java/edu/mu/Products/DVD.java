package edu.mu.Products;

public class DVD extends Product {
	public DVD(String title, String author, ProductType type, String ID, ProductGenre genre) {
		super(title, author, type, ID, genre);
	}
	

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String getAuthor() {
		return author;
	}

	@Override
	public ProductType getType() {
		return type;
	}

	@Override
	public String getID() {
		return ID;
	}

	@Override
	public ProductGenre getGenre() {
		return genre;
	}
}
