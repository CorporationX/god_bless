package school.faang.library;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private Map<Book, String> bookLocations = new HashMap<>();

    public boolean addBook(@NonNull String title, @NonNull String author, int year, @NonNull String location) {
        if (title.isBlank() || author.isBlank() || location.isBlank() || year <= 0) {
            throw new IllegalArgumentException("Field is empty.");
        }

        Book book = new Book(title, author, year);

        if (!bookLocations.containsKey(book)) {
            bookLocations.put(book, location);
            return true;
        }

        return false;
    }

    public boolean removeBook(@NonNull String title, @NonNull String author, int year) {
        if (title.isBlank() || author.isBlank() || year <= 0) {
            throw new IllegalArgumentException("Field is empty.");
        }

        Book book = new Book(title, author, year);

        if (bookLocations.containsKey(book)) {
            bookLocations.remove(book);
            return true;
        }

        return false;
    }

    public boolean findBook(@NonNull String title, @NonNull String author, int year) {
        if (title.isBlank() || author.isBlank() || year <= 0) {
            throw new IllegalArgumentException("Field is empty.");
        }

        Book book = new Book(title, author, year);

        if (bookLocations.containsKey(book)) {
            System.out.println(String.format("Your book is here: %s", bookLocations.get(book)));
            return true;
        }

        return false;
    }

    public void printAllBooks() {
        bookLocations.forEach((book, location)
                -> System.out.println(String.format("Book found: %s, location: %s", book, location)));
    }
}
