package school.faang;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> library = new HashMap<>();

    public boolean addBook(String title, String author, int year, String location) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println(LibraryMessages.TITLE_AUTHOR_LOCATION_NULL_ERROR.getMessage());
            return false;
        }
        if (author == null || author.trim().isEmpty()) {
            System.out.println(LibraryMessages.TITLE_AUTHOR_LOCATION_NULL_ERROR.getMessage());
            return false;
        }
        if (location == null || location.trim().isEmpty()) {
            System.out.println(LibraryMessages.TITLE_AUTHOR_LOCATION_NULL_ERROR.getMessage());
            return false;
        }
        if (year <= 0 || year > 2025) {
            System.out.println("Year must be a positive number and not in the future!");
            return false;
        }
        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            System.out.println(book + LibraryMessages.BOOK_ALREADY_EXISTS.getMessage());
            return false;
        }
        library.put(book, location);
        System.out.println(book + LibraryMessages.BOOK_ADDED_SUCCESS.getMessage() + location);
        return true;
    }

    public boolean removeBook(String title, String author, int year) {
        if (title == null || author == null) {
            System.out.println(LibraryMessages.TITLE_AUTHOR_LOCATION_NULL_ERROR.getMessage());
            return false;
        }
        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            library.remove(book);
            System.out.println(book + LibraryMessages.BOOK_REMOVED_SUCCESS.getMessage());
            return true;
        } else {
            System.out.println(book + LibraryMessages.BOOK_NOT_FOUND.getMessage());
            return false;
        }
    }

    public void findBook(String title, String author, int year) {
        if (title == null || author == null) {
            System.out.println(LibraryMessages.TITLE_AUTHOR_LOCATION_NULL_ERROR.getMessage());
            return;
        }
        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            System.out.println(book + " found at " + library.get(book));
        } else {
            System.out.println(book + LibraryMessages.BOOK_NOT_FOUND.getMessage());
        }
    }

    public void printAllBooks() {
        System.out.println("\nLibrary contains the following books: ");
        for (var entry : library.entrySet()) {
            System.out.println(entry.getKey() + " is located at " + entry.getValue());
        }
    }
}

