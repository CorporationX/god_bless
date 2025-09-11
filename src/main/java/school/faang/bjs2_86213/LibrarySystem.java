package school.faang.bjs2_86213;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static final Map<Book, String> BOOKS = new HashMap<>();

    public static void addBook(@NonNull String title, @NonNull String author, int year,
                               @NonNull String location) {
        BOOKS.put(new Book(title, author, year), location);
    }

    public static void removeBook(String title, String author, int year) {
        BOOKS.remove(new Book(title, author, year));
    }

    public static void findBook(String title, String author, int year) {
        final Book book = new Book(title, author, year);
        final String bookLocation = BOOKS.get(book);

        if (bookLocation == null) {
            System.out.printf("Location for %s not found.\n", book);
        } else {
            System.out.printf("Location for book: %s is %s.\n", book, bookLocation);
        }
    }

    public static void printAllBooks() {
        if (BOOKS.isEmpty()) {
            System.out.println("Books library is empty");
            return;
        }

        for (Map.Entry<Book, String> booksEntry : BOOKS.entrySet()) {
            System.out.printf("Location for book: %s is %s.\n", booksEntry.getKey(), booksEntry.getValue());
        }
    }
}