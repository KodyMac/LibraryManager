package model;

import java.time.LocalDate;

public class BorrowedBook {
	private Book book;
	private User user;
	private LocalDate dueDate;
	
	public BorrowedBook(Book book, User user, LocalDate dueDate) {
		this.book=book;
		this.user=user;
		this.dueDate=dueDate;
	}

	public Book getBook() {
		return book;
	}

	public User getUser() {
		return user;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}
}
