package Utils;			// Declaring this class is in 'Utils' Package

import Model.Book;		// Imports the Book Class
import Model.Member;	// Imports the Member Class

import java.io.*;		// Imports the Java Classes for file reading/writing
import java.util.*;		// Imports the Java Utility Classes like List and ArrayList

public class FileLoader {			// This class handles loading data from text files
    private static FileLoader instance;		// A static variable holding the single instance of this class (Singleton)

    private FileLoader() {}		// Private constructor to prevent direct creation of FileLoader objects from outside

    public static FileLoader getInstance() {		// Static method to get the only instance of this class
        if (instance == null) {						// If no instance exists create one
            instance = new FileLoader();
        }
        return instance;		// Return the single instance
    }

    public List<Member> loadMembers(String filepath) {		// Method to load members from a file and return them as a list
        List<Member> members = new ArrayList<>();			// Create a list to hold members

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {		// Open the file to read
            String line;

            while ((line = reader.readLine()) != null) {		// Read each line from the file
                String[] parts = line.split(",");				// Split the line into parts using comma
                if (parts.length == 4) {						// Make sure the line has 4 parts
                    String id = parts[0].trim();				// Get the ID
                    String firstName = parts[1].trim();			// Get the first name
                    String lastName = parts[2].trim();			// Get the last name
                    int age = Integer.parseInt(parts[3].trim());	// Convert the age from String to int

                    members.add(new Member(id, firstName, lastName, age));		// Create a new Member object and add it to the list
                }
            }

        } catch (IOException | NumberFormatException e) {		// Handle any file reading or number conversion errors
            System.out.println("Error reading members file: " + e.getMessage());
        }

        return members;		// Return the list of members
    }

    public List<Book> loadBooks(String filepath) {		// Method to load books from a file and return them as a list
        List<Book> books = new ArrayList<>();			// Create a list to hold books

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {		// Open the file to read
            String line;

            while ((line = reader.readLine()) != null) {		// Read each line from the file
                String[] parts = line.split(",");				// Split the line into parts
                if (parts.length == 7) {						// Make sure there are 7 parts in the line
                    String id = parts[0].trim();			// Book ID
                    String isbn = parts[1].trim();			// ISBN
                    String title = parts[2].trim();			// Book Title
                    String author = parts[3].trim();		// Author Name
                    String pubDate = parts[4].trim();		// Publication Date
                    String genre = parts[5].trim();			// Genre of the book
                    int ageRating = Integer.parseInt(parts[6].trim());		// Convert age rating to an integer

                    books.add(new Book(id, isbn, title, author, pubDate, genre, ageRating));		// Create a new book object and add it to the list
                }
            }

        } catch (IOException | NumberFormatException e) {		// Handle file errors and invalid number format
            System.out.println("Error reading books file: " + e.getMessage());
        }

        return books;		// Return the list of books
    }
}