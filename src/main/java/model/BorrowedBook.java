package model;

import java.util.Date;

public class BorrowedBook {
	private Book book;
	private User user;
	private Date dueDate;
	
	public BorrowedBook(Book book, User user, Date dueDate) {
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

	public Date getDueDate() {
		return dueDate;
	}
}
