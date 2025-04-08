package Model;

public class Book {
	private String id;
	private String isbn;
	private String title;
	private String author;
	private String publicationDate;
	private String genre;
	private int ageRating;
	private String borrowedByMemberId;
	
	
	public Book(String id, String isbn, String title, String author, String publicationDate, String genre, int ageRating) {
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publicationDate = publicationDate;
		this.genre = genre;
		this.ageRating = ageRating;
	}
	
	public String getId() {
		return id;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getPublicationDate() {
		return publicationDate;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public int getAgeRating() {
		return ageRating;
	}
	
	public String getBorrowedByMemberId() {
		return borrowedByMemberId;
	}
	
	public void setBorrowedByMemberId(String memberId) {
		this.borrowedByMemberId = memberId;
	}
	
	public boolean isAvailable() {
		return borrowedByMemberId == null || borrowedByMemberId.isEmpty();
	}
	
	public boolean isBorrowed() {
		return !isAvailable();
	}
	
	public static String getHeader() {
		return String.format("%-5s %-10s %-30s %-20s %-12s %-12s %-3s %-10s", "ID", "ISBN", "Title", "Author", "Pub Date", "Genre", "Age", "Status");
	}
	
	public String toString() {
		String status = isBorrowed() ?  "Borrowed" : "Available";
		return String.format("%-5s %-10s %-30s %-20s %-12s %-12s %3d %-10s", id, isbn, title, author, publicationDate, genre, ageRating, status);
	}
}
