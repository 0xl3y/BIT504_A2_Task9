package App;

import Model.Book;
import Model.Member;
import Utils.FileLoader;

import java.util.List;

public class Library {
	public static void main(String[] args) {
		FileLoader loader = FileLoader.getInstance();
		
		List<Member> members = loader.loadMembers("members.txt");
		List<Book> books = loader.loadBooks("books.txt");
		
		System.out.println("Loaded Members:");
		for (Member m : members) {
			System.out.println(m);
		}
		
		System.out.println("\nLoadedBooks:");
		for (Book b: books) {
			System.out.println(b);
		}
		
		
	}
}
