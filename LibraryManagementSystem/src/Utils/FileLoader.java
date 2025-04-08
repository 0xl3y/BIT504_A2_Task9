package Utils;

import Model.Book;
import Model.Member;

import java.io.*;
import java.util.*;

public class FileLoader {
    private static FileLoader instance;

    private FileLoader() {}

    public static FileLoader getInstance() {
        if (instance == null) {
            instance = new FileLoader();
        }
        return instance;
    }

    public List<Member> loadMembers(String filepath) {
        List<Member> members = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String id = parts[0].trim();
                    String firstName = parts[1].trim();
                    String lastName = parts[2].trim();
                    int age = Integer.parseInt(parts[3].trim());

                    members.add(new Member(id, firstName, lastName, age));
                }
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading members file: " + e.getMessage());
        }

        return members;
    }

    public List<Book> loadBooks(String filepath) {
        List<Book> books = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    String id = parts[0].trim();
                    String isbn = parts[1].trim();
                    String title = parts[2].trim();
                    String author = parts[3].trim();
                    String pubDate = parts[4].trim();
                    String genre = parts[5].trim();
                    int ageRating = Integer.parseInt(parts[6].trim());

                    books.add(new Book(id, isbn, title, author, pubDate, genre, ageRating));
                }
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading books file: " + e.getMessage());
        }

        return books;
    }
}