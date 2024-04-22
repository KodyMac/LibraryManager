package edu.mu;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import edu.mu.Products.Book;
import edu.mu.User.User;

public class Library {
	private List<Book> books;
	private Map<User, Map<List<Book>,LocalDate>> checkedOut; //list of checked out books, along with the User who checked it out and the dueDate

	
}
