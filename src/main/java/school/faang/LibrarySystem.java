package school.faang;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static final Map<Book, String> library = new HashMap<>();

    public boolean addBook(String title, String author, int year, String location) {
        if (title == null || author == null || location == null) {
            System.out.println("Title, author or location must not be null!");
            return false;
        }
        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            System.out.println(book + " is already in the library!");
            return false;
        }
        library.put(book, location);
        System.out.println(book + " added at location " + location);
        return true;
    }

    public boolean removeBook(String title, String author, int year) {
        if (title == null || author == null) {
            System.out.println("Title or author must not be null!");
            return false;
        }
        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            library.remove(book);
            System.out.println(book + " successfully removed!");
            return true;
        } else {
            System.out.println(book + " doesn't exist!");
            return false;
        }
    }

    public void findBook(String title, String author, int year) {
        if (title == null || author == null) {
            System.out.println("Title or author must not be null!");
            return;
        }
        Book book = new Book(title, author, year);
        if (library.get(book) != null) {
            System.out.println(book + " found at " + library.get(book));
        } else {
            System.out.println(book + " was not found!");
        }
    }

    public void printAllBooks() {
        System.out.println("\nLibrary contains the following books: ");
        for (var entry : library.entrySet()) {
            System.out.println(entry.getKey() + " is located at " + entry.getValue());
        }
    }
}
