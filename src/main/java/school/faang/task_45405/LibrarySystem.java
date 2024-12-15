package school.faang.task_45405;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> locationByBook = new HashMap<>();

    protected void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);

        if (locationByBook.containsKey(book)) {
            System.out.println("Book already exists: " + book);
        } else {
            locationByBook.put(book, location);
            System.out.println("Book added: " + book);
        }
    }

    protected void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);

        if (locationByBook.remove(book) != null) {
            System.out.println("Book removed: " + book);
        } else {
            System.out.println("Book not found: " + book);
        }
    }

    protected void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = locationByBook.get(book);

        if (location == null) {
            System.out.println("Book not found: " + book);
        } else {
            System.out.println("Book found at: " + location + ", details: " + book);
        }
    }

    protected void printAllBooks() {
        if (locationByBook.isEmpty()) {
            System.out.println("No books in the library!");
        } else {
            System.out.println("Books in the library:");
            locationByBook.forEach((book, location) -> System.out.println(book + " is located at " + location));
        }
    }

    protected Map<Book, String> getBooks() {
        return new HashMap<>(locationByBook);
    }
}