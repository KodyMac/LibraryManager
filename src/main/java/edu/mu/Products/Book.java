package edu.mu.Products;

public class Book extends Product {
	public Book(String title, String author, ProductType type, /*String ID,*/ ProductGenre genre) {
		super(title, author, type, /*ID,*/ genre);
	}

//	public boolean isAvailable() {
//		return available;
//	}
//	
//	@Override
//	public String getTitle() {
//		return title;
//	}
//
//	@Override
//	public String getAuthor() {
//		return author;
//	}
//
//	@Override
//	public ProductType getType() {
//		return type;
//	}
//
//	@Override
//	public ProductGenre getGenre() {
//		return genre;
//	}
//
//	@Override
//	public void setTitle(String title) {
//		this.title=title;
//	}
//
//	@Override
//	public void setAuthor(String author) {
//		this.author=author;
//	}
//
//	@Override
//	public void setAvailable(boolean avail) {
//		this.available=avail;
//	}
}
