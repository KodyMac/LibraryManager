package controller;

import model.Book;
import view.UserView;

public class BookController {
	private Book model;
	private UserView view;
	
	public BookController(Book model, UserView view) {
		this.model=model;
		this.view=view;
	}
	
	public void updateBook(String title, String author, String genre) {
		model.setTitle(title);
		model.setAuthor(author);
		model.setGenre(genre);
	}
	
	public void displayBookInfo() {
		
	}
}
