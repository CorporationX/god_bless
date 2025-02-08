package school.faang.library;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static Map<Book, String> bookPlace = new HashMap<>();

    public boolean addBook(String titlle, String author, int year, String location) {
        if (titlle.isBlank() || author.isBlank() || location.isBlank() || year == 0) {
            throw new IllegalArgumentException("Field is empty.");
        }

        Book book = new Book(titlle, author, year);

        if (!bookPlace.containsKey(book)) {
            bookPlace.put(book, location);
            return true;
        }

        return false;
    }

    public boolean removeBook(String titlle, String author, int year) {
        if (titlle.isBlank() || author.isBlank() || year == 0) {
            throw new IllegalArgumentException("Field is empty.");
        }

        Book book = new Book(titlle, author, year);

        if (bookPlace.containsKey(book)) {
            bookPlace.remove(book);
            return true;
        }

        return false;
    }

    public boolean findBook(String titlle, String author, int year) {
        if (titlle.isBlank() || author.isBlank() || year == 0) {
            throw new IllegalArgumentException("Field is empty.");
        }

        Book book = new Book(titlle, author, year);

        if (bookPlace.containsKey(book)) {
            System.out.println("Your book is here: " + bookPlace.get(book));
            return true;
        }

        return false;
    }

    public void printAllBooks() {
        bookPlace.forEach((book, location)
                -> System.out.println("Book found: " + book + " , location: " + location));
    }
}
