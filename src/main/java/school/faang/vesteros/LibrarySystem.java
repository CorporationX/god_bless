package school.faang.vesteros;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Danil Pudovkin
 * @since 05.06.2025
 */
public class LibrarySystem {

    private final Map<Book, String> bookLocations = new HashMap<>();

    public void addBook(@NonNull String title, @NonNull String author,
                               int year, @NonNull String location) {
        var book = new Book(title, author, year);
        bookLocations.put(book, location);
    }

    public void removeBook(@NonNull String title, @NonNull String author, int year) {
        var book = new Book(title, author, year);
        var removed = bookLocations.remove(book);
        if (removed == null) {
            System.out.println("Book not found");
        }
    }

    public String findBook(@NonNull String title, @NonNull String author, int year) {
        var book = new Book(title, author, year);
        var foundBook = bookLocations.get(book);
        if (foundBook == null) {
            System.out.println("Book not found");
        }
        return foundBook;
    }

    public void printBooks() {
        System.out.println("Book locations:");
        for (var bookEntry : bookLocations.entrySet()) {
            System.out.printf("%s : %s%n", bookEntry.getKey(), bookEntry.getValue());
        }
    }
}
