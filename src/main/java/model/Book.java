package model;

public class Book {
	private int bookID;
	private String title;
	private String author;
	private String genre;
	//private boolean isBorrowed;
	static int currentIDNum = 0;
	//private String ISBN;
	
	public Book(int id, String title, String author, String genre, boolean borrowed) {
		currentIDNum++;
		if(id==-1) {
			bookID=currentIDNum;
		} else
			bookID=id;
		this.title=title;
		this.author=author;
		this.genre=genre;
		//this.isBorrowed=borrowed;
		//this.ISBN=ISBN;
	}
	
	//print book info
	public void printInfo() {
		System.out.println(title + "\t\t" + author + "\t\t" + genre);
	}
	
	public int getID() {
		return bookID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
}
