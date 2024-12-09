package school.faang.vesteroslibrary;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    HashMap<Book, String> bookMap = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        bookMap.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        bookMap.remove(book);
        System.out.println("Книга удалена");
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        System.out.println(bookMap.getOrDefault(book, "Книга не найдена"));
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> book : bookMap.entrySet()) {
            System.out.println(book);
        }
    }
}
