package school.faang;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> bookLocation = new HashMap<>();

    private void validateLocation(String location) {
        if (location == null || location.isBlank()) {
            throw new IllegalArgumentException("Location can't be null or blank");
        }
    }

    public void addBook(String title, String author, int year, String location) {
        validateLocation(location);
        Book book = new Book(title, author, year);
        bookLocation.put(book, location);
    }

    public boolean removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return bookLocation.remove(book) != null;
    }

    public boolean findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return bookLocation.containsKey(book);
    }

    public void printAllBooks() {
        for (var entry : bookLocation.entrySet()) {
            System.out.printf("Location of book %s is %s\n", entry.getKey(), entry.getValue());
        }
    }
}
