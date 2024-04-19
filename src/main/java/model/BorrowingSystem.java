package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BorrowingSystem {
	private List<BorrowedBook> borrowedBooks;
	
	public BorrowingSystem() {
		this.borrowedBooks=new ArrayList<>();
	}
	
	public void borrowBook(Book book, User user) {
		LocalDate dueDate = LocalDate.now().plusDays(7);
		
		BorrowedBook borrowedBook = new BorrowedBook(book, user, dueDate);
		borrowedBooks.add(borrowedBook);
		
		//other methods for borrowing
	}
	
	public void returnBook(Book book) {
		
		
		//methods for returning. maybe specific to each user?
	}
	
	public LocalDate getDueDate(Book book) {
		for(BorrowedBook borrowedBook : borrowedBooks) {
			if(borrowedBook.getBook().equals(book)) {
				return borrowedBook.getDueDate();
			}
		}
		return null; //book not found or wasn't borrowed
	}
	
	//other methods for managing borrowing and returning
}
