package school.faang.bjs2_79617_vesteros_lib;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LibrarySystem {
    private static final Map<Book, String> LIBRARY = new HashMap<>();

    public static void addBook(Book book, String location) {
        if (book == null || location == null) {
            throw new IllegalArgumentException("Book and location must not be null.");
        }
        LIBRARY.put(book, location);
    }

    public static void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        LIBRARY.remove(book);
    }

    public static void printAllBooks() {
        for (Entry<Book, String> entry : LIBRARY.entrySet()) {
            Book book = entry.getKey();
            System.out.println(book.getTitle() + " at location " + entry.getValue());
        }
    }

    public static void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String result = LIBRARY.get(book);
        if (result != null) {
            System.out.println(book.getTitle() + " found at " + result);
        } else {
            System.out.println("Book not found");
        }
    }
}
