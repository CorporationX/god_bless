package school.faang.library;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static String CONTAINS_MESSAGE = "Can not add the book. It is already in the library. " +
            "Do not need the extra example";
    private static String ADD_MESSAGE = "The book was added to the library. It is located in ";
    private static String REMOVE_MESSAGE = "The book was removed from the library";
    private static String LOCATION_MESSAGE = "The book location is ";
    private static String BOOK_NOT_FOUND_MESSAGE = "In the library there is no book ";
    private Map<Book, String> bookLocation = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        if (bookLocation.containsKey(new Book(title, author, year))) {
            System.out.println(CONTAINS_MESSAGE);
        } else {
            bookLocation.put(new Book(title, author, year), location);
            System.out.println(ADD_MESSAGE + location);
        }
    }

    public void removeBook(String title, String author, int year) {
        Book bookToRemove = new Book(title, author, year);
        bookLocation.remove(bookToRemove);
        if (!bookLocation.containsKey(bookToRemove)) {
            System.out.println(REMOVE_MESSAGE);
        }
    }

    public void findBook(String title, String author, int year) {
        if (bookLocation.containsKey(new Book(title, author, year))) {
            String location = bookLocation.get(new Book(title, author, year));
            System.out.println(LOCATION_MESSAGE + location);
        } else {
            System.out.println(BOOK_NOT_FOUND_MESSAGE + title);
        }

    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : bookLocation.entrySet()) {
            System.out.println("Book " + entry.getKey() + " is located in " + entry.getValue());
        }
    }
}
