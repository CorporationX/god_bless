package school.faang.task_57165;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static final Map<Book, String> BOOKS = new HashMap<>();
    private static final String MESSAGE_OF_ADD_BOOK;
    private static final String MESSAGE_OF_DELETE_BOOK;
    private static final String MESSAGE_OF_FINDING_BOOK;
    private static final String NOT_FOUND_BOOK_MESSAGE;
    private static final String LOCATION_BOOK_MESSAGE;

    static {
        MESSAGE_OF_ADD_BOOK = "ADDING: %s has been added to the %s.\n";
        MESSAGE_OF_DELETE_BOOK = "DELETING: %s has been deleted.\n";
        MESSAGE_OF_FINDING_BOOK = "FINDING: %s was found on the %s.\n";
        NOT_FOUND_BOOK_MESSAGE = "FINDING: %s was not found.\n";
        LOCATION_BOOK_MESSAGE = "%s is on the %s.\n";
    }

    public static void addBook(@NonNull Book book, @NonNull String location) {
        BOOKS.put(book, location);
        System.out.printf(MESSAGE_OF_ADD_BOOK, book, location);
    }

    public static void removeBook(@NonNull Book book) {
        if (BOOKS.remove(book) != null) {
            System.out.printf(MESSAGE_OF_DELETE_BOOK, book);
        }
    }

    public static void findBook(@NonNull Book book) {
        if (BOOKS.containsKey(book)) {
            System.out.printf(MESSAGE_OF_FINDING_BOOK, book, BOOKS.get(book));
        } else {
            System.out.printf(NOT_FOUND_BOOK_MESSAGE, book);
        }
    }

    public static void printAllBooks() {
        BOOKS.forEach((book, location) -> System.out.printf(LOCATION_BOOK_MESSAGE,
                book, location));
    }
}
