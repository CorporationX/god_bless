package school.faang.hashmap;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> library;

    public LibrarySystem() {
        this.library = new HashMap<>();
    }

    public void addBook(String title, String author, int year, String location) {
        if (title == null || title.trim().isEmpty()) {
            return;
        }
        if (author == null || author.trim().isEmpty()) {
            return;
        }
        if (location == null || location.trim().isEmpty()) {
            return;
        }

        Book book = new Book(title, author, year);
        library.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        if (title == null || title.trim().isEmpty() || author == null || author.trim().isEmpty() || year <= 0) {
            return;
        }

        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            library.remove(book);
            System.out.println("Book removed: " + book);
        } else {
            System.out.println("Book not found");
        }
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (title == null || title.trim().isEmpty() || author == null || author.trim().isEmpty() || year <= 0) {
            return;
        }

        if (library.containsKey(book)) {
            System.out.println("Book found at location: " + library.get(book));
        } else {
            System.out.println("Book not found: " + book +
                    ". Perhaps the book is not in the library or the search criteria are set incorrectly.");
        }
    }

    public void printAllBooks() {
        if (library.isEmpty()) {
            System.out.println("Library is empty");
        } else {
            for (Map.Entry<Book, String> entry : library.entrySet()) {
                System.out.println(entry.getKey() + " location: " + entry.getValue());
            }
        }
    }
}
