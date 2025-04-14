package Model;			// Declaring class is in the 'Model' Package

public class Book {			// Defines a class called Book
	private String id;		// Unique ID for the book
	private String isbn;	// ISBN number of the book
	private String title;	// Title of the book
	private String author;	// Author of the book
	private String publicationDate;		// Publication date of the book
	private String genre;				// Genre of the book
	private int ageRating;				// Age rating for the book
	private String borrowedByMemberId;	// ID of the member who borrowed the book
	
	
	// Constructor to create a new Book object with all the details
	public Book(String id, String isbn, String title, String author, String publicationDate, String genre, int ageRating) {
		this.id = id;				// Set the ID
		this.isbn = isbn;			// Set the ISBN
		this.title = title;			// Set the title
		this.author = author;		// Set the author
		this.publicationDate = publicationDate;		// Set the publication date
		this.genre = genre;			// Set the genre
		this.ageRating = ageRating;		// Set the age rating
	}
	
	// Getter method for ID
	public String getId() {
		return id;
	}
	
	// Getter method for ISBN
	public String getIsbn() {
		return isbn;
	}
	
	// Getter method for Title
	public String getTitle() {
		return title;
	}
	
	// Getter method for Author
	public String getAuthor() {
		return author;
	}
	
	// Getter method for Publication Date
	public String getPublicationDate() {
		return publicationDate;
	}
	
	// Getter method for Genre
	public String getGenre() {
		return genre;
	}
	
	// Getter method for Age Rating
	public int getAgeRating() {
		return ageRating;
	}
	
	// Getter method for Borrowed Member ID
	public String getBorrowedByMemberId() {
		return borrowedByMemberId;
	}
	
	// Setter method to set the ID of the member who borrowed the book
	public void setBorrowedByMemberId(String memberId) {
		this.borrowedByMemberId = memberId;
	}
	
	// Method to check if the book is available (not borrowed)
	public boolean isAvailable() {
		return borrowedByMemberId == null || borrowedByMemberId.isEmpty();
	}
	
	// Method to check if the book is currently borrowed
	public boolean isBorrowed() {
		return !isAvailable();		// if not available, is borrowed
	}
	
	// Static method to return a formatted header for displaying books
	public static String getHeader() {
		return String.format("%-5s %-10s %-30s %-20s %-12s %-12s %-3s %-10s", "ID", "ISBN", "Title", "Author", "Pub Date", "Genre", "Age", "Status");
	}
	
	// String method to return a formatted string with book details and it's availability
	public String toString() {
		String status = isBorrowed() ?  "Borrowed" : "Available";		// Set status based on availability
		return String.format("%-5s %-10s %-30s %-20s %-12s %-12s %3d %-10s", id, isbn, title, author, publicationDate, genre, ageRating, status);
	}
}
