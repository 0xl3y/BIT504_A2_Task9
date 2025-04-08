package Menu;

import java.util.Scanner;

public class MenuManager {
		private Scanner scanner;
		
		public MenuManager() {
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
				System.out.println("Enter an oprion: ");
				choice = scanner.nextLine().trim().toLowerCase();
				
				switch (choice) {
					case "a":
						// displayAllBooks();
						break;
					case "b":
						// displayBorrowedBooks();
						break;
					case "c":
						// displayUnborrowedBooks();
						break;
					case "d":
						// addNewBook();
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
                    // displayAllMembers();
                    break;
                case "b":
                    // addNewMember();
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
                    // checkOutBook();
                    break;
                case "b":
                    // checkInBook();
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
                    // findMember();
                    break;
                case "b":
                    // findBook();
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