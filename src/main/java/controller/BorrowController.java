package controller;

import java.time.LocalDate;

import model.Book;
import model.BorrowingSystem;
import model.User;
import view.UserView;

public class BorrowController {
	private BorrowingSystem model;
	private UserView view;
	
	public BorrowController(BorrowingSystem model, UserView view) {
		this.model=model;
		this.view=view;
	}
	
	public void borrowBook(Book book, User user) {//, LocalDate dueDate) {
		model.borrowBook(book, user);
	}
	
	public void returnBook(Book book) {
		model.returnBook(book);
	}
}
