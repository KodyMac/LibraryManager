package edu.mu.Products;

public abstract class Product {
	protected String title;
	protected String author;
	protected ProductType type;
	protected ProductGenre genre;
	protected boolean available;
	
	public Product(String title, String author, ProductType type, ProductGenre genre) {
		this.title=title;
		this.author=author;
		this.type=type;
		//this.ID=ID;
		this.genre=genre;
	}
	
	public boolean isAvailable() {
		return available;
	}
	
	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public ProductType getType() {
		return type;
	}

	public ProductGenre getGenre() {
		return genre;
	}
	
	public void setTitle(String title) {
		this.title=title;
	}
	
	public void setAuthor(String author) {
		this.author=author;
	}
	
	public void setAvailable(boolean avail) {
		this.available=avail;
	}
	
	
}
