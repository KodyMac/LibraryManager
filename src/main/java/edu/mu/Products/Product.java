package edu.mu.Products;

public abstract class Product {
	protected String title;
	protected String author;
	protected ProductType type;
	//protected genericGenreType genre;
	protected String ID;
	
	public Product(String title, String author, ProductType type, String ID) {
		this.title=title;
		this.author=author;
		this.type=type;
		this.ID=ID;
	}
	
	//public abstract String getType();
	public abstract void getInfo();
	
}
