package school.faang.bjs2_68667;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> bookLocation = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        this.bookLocation.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        if (!this.bookLocation.containsKey(new Book(title, author, year))) {
            throw new BookNotFoundException("Book " + title + " not found");
        }
        this.bookLocation.remove(new Book(title, author, year));
    }

    public String findBook(String title, String author, int year) {
        if (!this.bookLocation.containsKey(new Book(title, author, year))) {
            throw new BookNotFoundException("Book " + title + " not found");
        }
        return this.bookLocation.get(new Book(title, author, year));
    }

    public void printAllBook() {
        for (Map.Entry<Book, String> bookInLibrary : this.bookLocation.entrySet()) {
            System.out.println(bookInLibrary);
        }
    }
}
