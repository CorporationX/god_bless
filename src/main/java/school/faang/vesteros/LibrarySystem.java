package school.faang.vesteros;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Danil Pudovkin
 * @since 05.06.2025
 */
public class LibrarySystem {

    private static final Map<Book, String> BOOK_LOCATIONS = new HashMap<>();

    public static void addBook(@NonNull String title, @NonNull String author,
                               @NonNull int year, @NonNull String location) {
        var book = new Book(title, author, year);
        BOOK_LOCATIONS.put(book, location);
    }

    public static void removeBook(@NonNull String title, @NonNull String author, @NonNull int year) {
        var book = new Book(title, author, year);
        var removed = BOOK_LOCATIONS.remove(book);
        if (removed == null) {
            System.out.println("Book not found");
        }
    }

    public static String findBook(@NonNull String title, @NonNull String author, @NonNull int year) {
        var book = new Book(title, author, year);
        var foundBook = BOOK_LOCATIONS.get(book);
        if (foundBook == null) {
            System.out.println("Book not found");
        }
        return foundBook;
    }

    public static void printBooks() {
        System.out.println("Book locations:");
        for (var bookEntry : BOOK_LOCATIONS.entrySet()) {
            System.out.printf("%s : %s\n", bookEntry.getKey(), bookEntry.getValue());
        }
    }
}
