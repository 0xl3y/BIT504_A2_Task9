package App;

import Menu.MenuManager;
import Utils.FileLoader;
import Model.Book;
import Model.Member;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		FileLoader loader = FileLoader.getInstance();
		List<Book> books = loader.loadBooks("books.txt");
		List<Member> members = loader.loadMembers("members.txt");
		
		MenuManager menuManager = new MenuManager(books, members);
		menuManager.showMainMenu();
	}
}
