package Menu;

import java.util.Scanner;
import java.util.List;
import Model.Book;
import Model.Member;

public class MenuManager {
		private Scanner scanner;
		private List<Book> books;
		private List<Member> members;
		
		private void displayAllBooks() {
			System.out.println(Book.getHeader());
			for (Book b : books) {
				System.out.println(b);
			}
		}
		
		private void displayBorrowedBooks() {
			System.out.println("=== Borrowed Books ===");
			System.out.println(Book.getHeader());
			for (Book b: books) {
				if (b.isBorrowed()) {
					System.out.println(b);
				}
			}
		}
		
		private void displayUnborrowedBooks() {
			System.out.println("=== Unborrowed Books ===");
			System.out.println(Book.getHeader());
			for (Book b: books) {
				if (!b.isBorrowed()) {
					System.out.println(b);
				}
			}
		}
		
		private void addNewBook() {
			String id, isbn, title, author, pubDate, genre;
			int ageRating;
			
			while(true) {
				System.out.print("Enter Book ID: ");
				id = scanner.nextLine().trim();
				boolean isIdUnique = true;
				for (Book b : books) {
					if (b.getId().equals(id)) {
						isIdUnique = false;
						System.out.println("ID already exists. Please enter a unique ID.");
						break;
					}
				}
				if (isIdUnique) break;
			}
			
			while (true) {
				System.out.println("Enter ISBN (10 Characters): ");
				isbn = scanner.nextLine().trim();
				if (isbn.length() == 10) break;
				System.out.println("Invalid ISBN. It must be 10 characters long.");
			}
				
				System.out.print("Enter Title: ");
				title = scanner.nextLine().trim();
				
				System.out.print("Enter Author: ");
				author = scanner.nextLine().trim();
				
				System.out.print("Enter Publication Date: ");
				pubDate = scanner.nextLine().trim();
				
				System.out.print("Enter Genre: ");
				genre = scanner.nextLine().trim();
				
				while (true) {
					System.out.println("Enter Age Rating (a number): ");
					try {
						ageRating = Integer.parseInt(scanner.nextLine().trim());
						break;
					} catch (NumberFormatException e) {
						System.out.println("Invalid input. Please enter a valid number for age rating");
					}
				}
				
				Book newBook = new Book(id, isbn, title, author, pubDate, genre, ageRating);
				books.add(newBook);
				System.out.println("Book Added Successfully.");
			}
		
		private void displayAllMembers() {
			System.out.println(Member.getHeader());
        	for (Member m : members) {
        		System.out.println(m);
        	}
		}
		
		private void addNewMember() {
			String id, firstName, lastName;
			int age;
			
			while (true) {
				System.out.print("Enter Member ID: ");
				id = scanner.nextLine().trim();
				boolean isIdUnique = true;
				for (Member m : members) {
					if (m.getId().equals(id)) {
						isIdUnique = false;
						System.out.println("ID already exists. Please enter a unique ID.");
						break;
					}
				}
				if (isIdUnique) break;
			}
        	
        	while (true) {
        		System.out.println("Enter First Name: ");
        		firstName = scanner.nextLine().trim();
        		if (!firstName.isEmpty()) break;
        		System.out.println("First name cannot be blank. Please enter a valid name.");
        	}
       
        	while (true) {
        		System.out.println("Enter Last Name: ");
        		lastName = scanner.nextLine().trim();
        		if (!lastName.isEmpty()) break;
        		System.out.println("Last name cannot be blank. Please enter a valid name.");
        	}
        	
        	while (true) {
        		System.out.print("Enter Age (0-125): ");
        		try {
        			age = Integer.parseInt(scanner.nextLine().trim());
        			if (age >= 0 && age <= 125) break;
        			System.out.println("Invalid age. Please enter a number between 0 and 125.");
        		} catch (NumberFormatException e) {
        			System.out.println("Invalid input. Please enter a valid number for age.");
        		}
        	}
        	
        	Member newMember = new Member(id, firstName, lastName, age);
        	members.add(newMember);
        	System.out.println("Member Added Successfully");
		}
		
		private void checkOutBook() {
			System.out.println("\n--- Check Out a Book ---");
			System.out.print("Enter Book ID: ");
			String bookId = scanner.nextLine().trim();
			
			Book book = findBookById(bookId);
			if (book == null) {
				System.out.println("Book not found");
				return;
			}
			
			if (!book.isAvailable()) {
				System.out.println("This book is already borrowed.");
				return;
			}
			
			System.out.print("Enter Member ID: ");
			String memberId = scanner.nextLine().trim();
			Member member = findMemberById(memberId);
			if (member == null) {
				System.out.println("Member not found.");
				return;
			}
			
			if (book.getAgeRating() > member.getAge()) {
				System.out.println("Sorry, you are not old enough to borrow this book.");
				return;
			}
			
			System.out.println("Book: " + book.getTitle());
			System.out.print("Do you want to borrow this book? (yes/no): ");
			String confirmation = scanner.nextLine().trim().toLowerCase();
			
			if (confirmation.equals("yes")) {
				book.setBorrowedByMemberId(memberId);
				System.out.println("Book successfully borrowed.");
			} else {
				System.out.println("Book borrowing cancelled");
			}
		}
		
		private Book findBookById(String bookId) {
			for (Book book : books) {
				if (book.getId().equals(bookId)) {
					return book;
				}
			}
			return null;
		}
			
			private Member findMemberById(String memberId) {
				for (Member member : members) {
					if (member.getId().equals(memberId)) {
						return member;
					}
				}
				return null;
		}
			
		private void checkInBook() {
			System.out.println("\n---Check In a Book ---");
			System.out.println("Enter Book ID to return: ");
			String bookId = scanner.nextLine().trim();
			
			Book book = findBookById(bookId);
			if (book == null) {
				System.out.println("Book not found.");
				return;
			}
			
			if (book.isAvailable()) {
				System.out.println("This book was not borrowed.");
				return;
			}
			
			book.setBorrowedByMemberId(null);
			System.out.println("Book successfully returned");	
		}
		
		
		private void findMember() {
			System.out.print("Enter last name to search: ");
			String search = scanner.nextLine().trim().toLowerCase();
			boolean found = false;
			
			for (Member m : members) {
				if (m.getLastName().toLowerCase().contains(search) ) {
					found = true;
					System.out.println("\n--- Member Found ---");
					System.out.println("ID: " + m.getId());
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
		
		private void findBook() {
			System.out.print("Enter book title to search: ");
			String search = scanner.nextLine().trim().toLowerCase();
			boolean found = false;
			
			for (Book b : books) {
				if (b.getTitle().toLowerCase().contains(search)) {
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
						Member borrower = findMemberById(memberId);
						String borrowerName = borrower != null
								? borrower.getFirstName() + " " + borrower.getLastName() : "Unknown";
						System.out.println("Borrowed by: " + borrowerName);
					} else {
						System.out.println("Status: Available");
					}
				}
				if (!found) {
					System.out.println("No books found with title containing: " + search);
				}
			}
		}
		
		
		
		public MenuManager(List<Book> books, List<Member> members) {
			this.books = books;
			this.members = members;
			scanner = new Scanner(System.in);
		}
		
		public void showMainMenu() {
			String choice;
			do {
				System.out.println("\n=== Main Menu ===");
				System.out.println("1. Book Management");
				System.out.println("2. Member Management");
				System.out.println("3. Loan Management");
				System.out.println("4. Search");
				System.out.println("5. Exit");
				System.out.println("Enter your choice: ");
				choice = scanner.nextLine().trim();
				
				switch (choice) {
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
				
			} while (!choice.equals("5"));
		}
		
		private void bookManagementMenu() {
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

    private void memberManagementMenu() {
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

    private void loanManagementMenu() {
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

    private void searchMenu() {
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