package model;

import java.util.Date;
import java.util.Map;

public class BorrowingSystem {
	private Map<Book, User> borrowedBooks;  //map to associate books with current owner
	private Map<Book, Date> dueDate;  //map to associate checked out books with the due date

	public BorrowingSystem() {
		;
	}
}
