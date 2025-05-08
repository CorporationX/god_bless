package school.faang;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class LibrarySystem {
    private final Map<Book, String> bookLocations = new HashMap<>();

    public void add(String title, String author, int year, String location) {
        bookLocations.putIfAbsent(new Book(title, author, year), location);
    }

    public void remove(String title, String author, int year) {
        bookLocations.remove(new Book(title, author, year));
    }

    public Book find(String title, String author, int year) {
        Book target = new Book(title, author, year);

        for (Map.Entry<Book, String> entry : bookLocations.entrySet()) {
            if (entry.getKey().equals(target)) {
                return target;
            }
        }

        throw new NoSuchElementException(
                "No book found with title " + title + " and author " + author + " and year " + year
        );
    }

    public void printAll() {
        bookLocations.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}
