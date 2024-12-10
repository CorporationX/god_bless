package school.faang.task_45356;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> librarySystem = new HashMap<>();


    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        librarySystem.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        librarySystem.remove(book);
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return librarySystem.get(book);
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> book : librarySystem.entrySet()) {
            System.out.println(book.getKey() + book.getValue());
        }
    }
}
