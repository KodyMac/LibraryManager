package edu.mu.Products;

public abstract class Product {
	protected String title;
	protected String author;
	protected ProductType type;
	//protected genericGenreType genre;
	//protected String ID;
	protected ProductGenre genre;
	protected boolean available;
	
	public Product(String title, String author, ProductType type, /*String ID,*/ ProductGenre genre) {
		this.title=title;
		this.author=author;
		this.type=type;
		//this.ID=ID;
		this.genre=genre;
	}
	
	//public abstract String getType();
	public abstract String getTitle();
	public abstract String getAuthor();
	public abstract ProductType getType();
	//public abstract String getID();
	public abstract ProductGenre getGenre();
	
}
