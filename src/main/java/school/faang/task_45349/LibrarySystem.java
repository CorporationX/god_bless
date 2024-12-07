package school.faang.task_45349;

import java.util.HashMap;
import java.util.Map;


public class LibrarySystem {
    private final Map<Book, String> library;

    public LibrarySystem() {
        library = new HashMap<>();
    }

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        library.put(book, location);
        System.out.printf("The book \"%s\" has been added\nLocation: %s.\n\n", title, location);
    }

    public boolean removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return library.remove(book) != null;
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return library.getOrDefault(book, "The book is not found in the library.");
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.printf("%s is on shelf: %s\n", entry.getKey(), entry.getValue());
        }
    }
}
