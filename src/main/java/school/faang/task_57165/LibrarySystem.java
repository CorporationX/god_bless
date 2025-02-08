package school.faang.task_57165;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static final Map<Book, String> BOOKS = new HashMap<>();
    private static final String NOT_FOUND_BOOK_MESSAGE = "The book was not found";

    public static void addBook(Book book, String location) {
        BOOKS.put(book, location);
    }

    public static void removeBook(Book book) {
        BOOKS.remove(book);
    }

    public static String findBook(Book book) {
        return BOOKS.getOrDefault(book, NOT_FOUND_BOOK_MESSAGE);
    }

    public static void printAllBooks() {
        BOOKS.forEach((book, location) -> System.out.println("Book: " + book + "\n" +
                "Location: " + location + "\n"));
    }
}
