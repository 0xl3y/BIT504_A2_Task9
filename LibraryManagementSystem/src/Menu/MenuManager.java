package Menu;			// Declaring the class is in the 'Menu' Package

import java.util.Scanner;		// Import Scanner for user input
import java.util.List;			// Import List to hold books and members
import Model.Book;				// Import Book class
import Model.Member;			// Import Member class

public class MenuManager {			// Defines MenuManager Class
		private Scanner scanner;	// Used to read input from the user
		private List<Book> books;	// List to store book objects
		private List<Member> members;		// List to store member objects
		
		private void displayAllBooks() {		// Method to display all books in the library
			System.out.println(Book.getHeader());		// Print Book Header
			for (Book b : books) {					// Loop through all books
				System.out.println(b);			// Print each books details
			}
		}
		
		private void displayBorrowedBooks() {	// Method to display only borrowed books
			System.out.println("=== Borrowed Books ===");	// Section header
			System.out.println(Book.getHeader());			// Print Book header
			for (Book b: books) {					// Loop through books
				if (b.isBorrowed()) {				// Check if book is borrowed
					System.out.println(b);			// Print borrowed book
				}
			}
		}
		
		private void displayUnborrowedBooks() {			// method to display books that are not borrowed
			System.out.println("=== Unborrowed Books ===");		// Section header
			System.out.println(Book.getHeader());			// Print book header
			for (Book b: books) {						//Loop through books
				if (!b.isBorrowed()) {				// Check if book is not borrowed
					System.out.println(b);			// Print available book
				}
			}
		}
		
		private void addNewBook() {			// Method to add a new book to the list
			String id, isbn, title, author, pubDate, genre;		// Variables for book details
			int ageRating;		// Variable for books age rating
			
			while(true) {		// Loop to make sure the book ID is unique
				System.out.print("Enter Book ID: ");		// Ask for book ID
				id = scanner.nextLine().trim();				// Read and trim input
				boolean isIdUnique = true;					// Assume ID is unique
				
				for (Book b : books) {				// Check if ID already exists
					if (b.getId().equals(id)) {
						isIdUnique = false;			// Found Duplicate
						System.out.println("ID already exists. Please enter a unique ID.");
						break;
					}
				}
				if (isIdUnique) break;		// Exit loop if ID is unique
			}
			
			while (true) {				// Loop to validate ISBN length
				System.out.println("Enter ISBN (10 Characters): ");		// Ask for ISBN
				isbn = scanner.nextLine().trim();		// Read and trim input
				if (isbn.length() == 10) break;			// Check if length is correct
				System.out.println("Invalid ISBN. It must be 10 characters long.");
			}
				
				System.out.print("Enter Title: ");
				title = scanner.nextLine().trim();		// Get book title
				
				System.out.print("Enter Author: ");
				author = scanner.nextLine().trim();		// Get author name
				
				System.out.print("Enter Publication Date: ");
				pubDate = scanner.nextLine().trim();	// Get publication date
				
				System.out.print("Enter Genre: ");
				genre = scanner.nextLine().trim();		// Get genre
	
				while (true) {			// Loop to validate age rating input
					System.out.println("Enter Age Rating (a number): ");
					try {
						ageRating = Integer.parseInt(scanner.nextLine().trim());		// Try to convert to int 
						break;		// Exit if successful
					} catch (NumberFormatException e) {
						System.out.println("Invalid input. Please enter a valid number for age rating");
					}
				}
				
				// Create and add the new book to the list
				Book newBook = new Book(id, isbn, title, author, pubDate, genre, ageRating);
				books.add(newBook);		// Add book to the list
				System.out.println("Book Added Successfully.");
			}
		
		private void displayAllMembers() {			// Method to display all members
			System.out.println(Member.getHeader());		// Print member header
        	for (Member m : members) {			// Loop through members
        		System.out.println(m);			// Print member details
        	}
		}
		
		private void addNewMember() {		// Method to add a new member to the list
			String id, firstName, lastName;		// Member info
			int age;						// Member age
			
			while (true) {			// Loop to make sure Member ID is unique
				System.out.print("Enter Member ID: ");		// Ask for member ID
				id = scanner.nextLine().trim();		// Read and trim input
				boolean isIdUnique = true;		// Assume ID is unique
				
				for (Member m : members) {		// Check if ID already exists in members list
					if (m.getId().equals(id)) {
						isIdUnique = false;		// Duplicate found
						System.out.println("ID already exists. Please enter a unique ID.");
						break;
					}
				}
				if (isIdUnique) break;		// Exit loop if ID is unique
			}
        	
        	while (true) {			// Loop to get a non-empty first name
        		System.out.println("Enter First Name: ");
        		firstName = scanner.nextLine().trim();
        		if (!firstName.isEmpty()) break;		// Continue only if not blank
        		System.out.println("First name cannot be blank. Please enter a valid name.");
        	}
       
        	while (true) {			// Loop to get a non-empty last name
        		System.out.println("Enter Last Name: ");
        		lastName = scanner.nextLine().trim();
        		if (!lastName.isEmpty()) break;		// Continue only if not blank
        		System.out.println("Last name cannot be blank. Please enter a valid name.");
        	}
        	
        	while (true) {			// Loop to get a valid age between 0 and 125
        		System.out.print("Enter Age (0-125): ");
        		try {
        			age = Integer.parseInt(scanner.nextLine().trim());		// Try parsing to integer
        			if (age >= 0 && age <= 125) break;			// Valid age range
        			System.out.println("Invalid age. Please enter a number between 0 and 125.");
        		} catch (NumberFormatException e) {
        			System.out.println("Invalid input. Please enter a valid number for age.");
        		}
        	}
        	
        	Member newMember = new Member(id, firstName, lastName, age);		// Create a new member and add to the list
        	members.add(newMember);
        	System.out.println("Member Added Successfully");		// Confirmation message
		}
		
		private void checkOutBook() {		// Method to check out a book to a member
			System.out.println("\n--- Check Out a Book ---");		// Section header
			System.out.print("Enter Book ID: ");			// Ask for book ID
			String bookId = scanner.nextLine().trim();		// Read Input
			
			Book book = findBookById(bookId);		// Find book by ID
			if (book == null) {				// If not found
				System.out.println("Book not found");
				return;			// Exit the method
			}
			
			if (!book.isAvailable()) {			// Check if already borrowed
				System.out.println("This book is already borrowed.");
				return;
			}
			
			System.out.print("Enter Member ID: ");			// Ask for member ID
			String memberId = scanner.nextLine().trim();	// Read Input
			Member member = findMemberById(memberId);		// Find by member ID
			if (member == null) {					// If not found
				System.out.println("Member not found.");
				return;
			}
			
			if (book.getAgeRating() > member.getAge()) {		// Check if member is old enough for the book
				System.out.println("Sorry, you are not old enough to borrow this book.");
				return;
			}
			
			// Confirm with user before proceeding 
			System.out.println("Book: " + book.getTitle());
			System.out.print("Do you want to borrow this book? (yes/no): ");
			String confirmation = scanner.nextLine().trim().toLowerCase();
			
			if (confirmation.equals("yes")) {
				book.setBorrowedByMemberId(memberId);			// Set who borrowed the book
				System.out.println("Book successfully borrowed.");
			} else {
				System.out.println("Book borrowing cancelled");
			}
		}
		
		// Helper method to find a book by its ID
		private Book findBookById(String bookId) {
			for (Book book : books) {
				if (book.getId().equals(bookId)) {
					return book;		// Found matching book
				}
			}
			return null;		// Not found
		}
			
		// Helper method to find a member by their ID
		private Member findMemberById(String memberId) {
			for (Member member : members) {
				if (member.getId().equals(memberId)) {
					return member;		// Found matching member
				}
			}
			return null;	// Not found
		}
			
		private void checkInBook() {		// Handles checking in a book
			System.out.println("\n---Check In a Book ---");
			System.out.println("Enter Book ID to return: ");
			String bookId = scanner.nextLine().trim();		// Get book ID input
			
			Book book = findBookById(bookId);		// Look for the book
			if (book == null) {
				System.out.println("Book not found.");		// If it doesn't exist
				return;
			}
			
			if (book.isAvailable()) {
				System.out.println("This book was not borrowed.");		// Already available
				return;
			}
			
			book.setBorrowedByMemberId(null);		// Mark the book as returned
			System.out.println("Book successfully returned");	
		}
		
		
		private void findMember() {		// Allows searching for members by last name
			System.out.print("Enter last name to search: ");
			String search = scanner.nextLine().trim().toLowerCase();	// Get search input
			boolean found = false;
			
			for (Member m : members) {
				if (m.getLastName().toLowerCase().contains(search) ) {		// check if members last name contains the search keyword
					found = true;
					System.out.println("\n--- Member Found ---");
					System.out.println("ID: " + m.getId());
					System.out.println("Name: " + m.getFirstName() + " " + m.getLastName());
					System.out.println("Age: " + m.getAge());
					
					boolean hasBorrowed = false;
					for (Book b : books) {
						if (m.getId().equals(b.getBorrowedByMemberId())) {
							if (!hasBorrowed) {
								System.out.println("Borrowed Books:");
								hasBorrowed = true;
							}
							System.out.println("- " + b.getTitle());
						}
					}
					if (!hasBorrowed) {
						System.out.println("Borrowed Books: None");
					}
				}
			}
		
			if (!found) {
				System.out.println("No members found with last name containing: " + search);
			}
		}
		
		private void findBook() {		// Allows searching for books by title
			System.out.print("Enter book title to search: ");
			String search = scanner.nextLine().trim().toLowerCase();		// Get search input
			boolean found = false;
			
			for (Book b : books) {
				if (b.getTitle().toLowerCase().contains(search)) {		// Check if the title contains the search string
					found = true;
					System.out.println("\n--- Book Found ---");
					System.out.println("ID: " + b.getId());
					System.out.println("ISBN: " + b.getIsbn());
					System.out.println("Title: " + b.getTitle());
					System.out.println("Author: " + b.getAuthor());
					System.out.println("Publication Date: " + b.getPublicationDate());
					System.out.println("Genre: " + b.getGenre());
					System.out.println("Age Rating: " + b.getAgeRating());
					
					if (b.isBorrowed()) {
						String memberId = b.getBorrowedByMemberId();
						Member borrower = findMemberById(memberId);		// FInd who borrowed it
						String borrowerName = borrower != null
								? borrower.getFirstName() + " " + borrower.getLastName() : "Unknown";
						System.out.println("Borrowed by: " + borrowerName);
					} else {
						System.out.println("Status: Available");
					}
				}
			}
			if (!found) {
				System.out.println("No books found with title containing: " + search);
			}
		}
		
		// Constructor to start the MenuManager with book and member lists
		public MenuManager(List<Book> books, List<Member> members) {
			this.books = books;
			this.members = members;
			scanner = new Scanner(System.in);		// For user input throughout the menu
		}
		
		public void showMainMenu() {		// The main menu that gets shown first and loops until the user exits
			String choice;
			do {		// Display main menu options
				System.out.println("\n=== Main Menu ===");
				System.out.println("1. Book Management");
				System.out.println("2. Member Management");
				System.out.println("3. Loan Management");
				System.out.println("4. Search");
				System.out.println("5. Exit");
				System.out.println("Enter your choice: ");
				choice = scanner.nextLine().trim();		// Get input
				
				switch (choice) {		// Handle user choice
				case "1":
					bookManagementMenu();
					break;
				case "2":
					memberManagementMenu();
					break;
				case "3":
					loanManagementMenu();
					break;
				case "4":
					searchMenu();
					break;
				case "5":
					System.out.println("Exiting Program...");
					break;
				default:
					System.out.println("Invalid choice. Try again.");
				}
				
			} while (!choice.equals("5"));		// Loop until exit option
		}
		
		private void bookManagementMenu() {		// Book management sub-menu
			String choice;
			do {
				System.out.println("\n--- Book Management ---");
				System.out.println("a. Display All Books");
				System.out.println("b. Display Borrowed Books");
				System.out.println("c. Display Unborrowed Books");
				System.out.println("d. Add a New Book");
				System.out.println("e. Return");
				System.out.println("Enter an option: ");
				choice = scanner.nextLine().trim().toLowerCase();
				
				switch (choice) {
					case "a":
						displayAllBooks();
						break;
					case "b":
						displayBorrowedBooks();
						break;
					case "c":
						displayUnborrowedBooks();
						break;
					case "d":
						addNewBook();
						break;
					case "e":
						System.out.println("Returning to main menu...");
						break;
					default:
						System.out.println("Invalid option. Try again.");
				}

			} while (!choice.equals("e"));
		}

    private void memberManagementMenu() {		// Member management sub-menu
        String choice;
        do {
            System.out.println("\n--- Member Management ---");
            System.out.println("a. Display all members");
            System.out.println("b. Add a new member");
            System.out.println("c. Return");
            System.out.print("Select an option: ");
            choice = scanner.nextLine().trim().toLowerCase();

            switch (choice) {
                case "a":
                	displayAllMembers();
                    break;
                case "b":
                	addNewMember();
                    break;
                case "c":
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (!choice.equals("c"));
    }

    private void loanManagementMenu() {		// Loan management sub-menu
        String choice;
        do {
            System.out.println("\n--- Loan Management ---");
            System.out.println("a. Check out a book");
            System.out.println("b. Check in a book");
            System.out.println("c. Return");
            System.out.print("Select an option: ");
            choice = scanner.nextLine().trim().toLowerCase();

            switch (choice) {
                case "a":
                    checkOutBook();
                    break;
                case "b":
                   checkInBook();
                    break;
                case "c":
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (!choice.equals("c"));
    }

    private void searchMenu() {		// Search sub-menu to find members or books
        String choice;
        do {
            System.out.println("\n--- Search ---");
            System.out.println("a. Find a member");
            System.out.println("b. Find a book");
            System.out.println("c. Return");
            System.out.print("Select an option: ");
            choice = scanner.nextLine().trim().toLowerCase();

            switch (choice) {
                case "a":
                    findMember();
                    break;
                case "b":
                    findBook();
                    break;
                case "c":
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (!choice.equals("c"));
    }
}