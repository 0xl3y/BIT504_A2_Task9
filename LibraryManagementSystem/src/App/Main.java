package App;

import Menu.MenuManager;
import Utils.FileLoader;
import Model.Book;
import Model.Member;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileLoader loader = FileLoader.getInstance();
        List<Book> books = loader.loadBooks("src/Books.txt");
        List<Member> members = loader.loadMembers("src/Members.txt");

        MenuManager menuManager = new MenuManager(books, members);
        menuManager.showMainMenu();
    }
}
