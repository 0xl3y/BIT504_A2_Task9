package App;		// Declaring this class is in 'App' Package

import Menu.MenuManager;		// Import MenuManager Class from Menu Package
import Utils.FileLoader;		// Import FileLoader Class from Utils Package
import Model.Book;				// Import Book Class from Model Package
import Model.Member;			// Import Member Class from Model Package

import java.util.List;			// Import the List Class from Java's library

public class Main {				// The Main Class starting the application
    public static void main(String[] args) {
        FileLoader loader = FileLoader.getInstance();		// Gets the single instance of FileLoader Class (uses the Singleton Pattern)
        List<Book> books = loader.loadBooks("src/Books.txt");		// Loads the list of books from the "Books.txt" file
        List<Member> members = loader.loadMembers("src/Members.txt");		// Loads the list of members from the "Members.txt" file

        MenuManager menuManager = new MenuManager(books, members);		// Creates a new MenuManager, passing in the members and books lists
        menuManager.showMainMenu();		// Starts the menu system, lets the user interact with the program
    }
}
