package school.faang.bjs2_68667;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> bookLocation;

    public LibrarySystem() {
        this.bookLocation = new HashMap<>();
    }

    public void addBook(String title, String author, int year, String location) {
        bookLocation.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        bookLocation.remove(new Book(title, author, year));
    }

    public String findBook(String title, String author, int year) {
        String locationInLibrary = bookLocation.get(new Book(title, author, year));
        if (locationInLibrary == null) {
            throw new BookNotFoundException("Book " + title + " not found");
        }
        return locationInLibrary;
    }

    public void printAllBook() {
        for (Map.Entry<Book, String> bookInLibrary : bookLocation.entrySet()) {
            System.out.println(bookInLibrary);
        }
    }
}
