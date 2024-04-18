package controller;

import model.Book;
import model.Catalog;
import view.UserView;

public class CatalogController {
	private Catalog model;
	private UserView view;
	
	public CatalogController(Catalog model, UserView view) {
		this.model=model;
		this.view=view;
	}
	
	public void addBookToCatalog(Book book) {
		model.addBook(book);
	}
	
	/*public void removeBookFromCatalog(Book book) {
		model.removeBook(book);
	}*/
}
