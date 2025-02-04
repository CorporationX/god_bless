package school.faang.library;

import java.util.HashMap;
import java.util.Map;


public class LibrarySystem {
    private final Map<Book, String> bookLocations = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        bookLocations.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (bookLocations.containsKey(book)) {

            System.out.printf("We have removed book %s from the shelf %s%n", book,
                    bookLocations.remove(new Book(title, author, year)));
        } else {
            System.out.printf("""
                    We can't delete this %s.
                    It's not in the system.
                    """, book);
        }

    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (bookLocations.containsKey(book)) {
            System.out.printf("""
                    The book has been found.
                    %s is on the shelf %s
                    """, book, bookLocations.get(book));
        } else {
            System.out.printf("Unfortunately we don't have %s%n", book);
        }

    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> bookLocation : bookLocations.entrySet()) {
            System.out.printf("%s is on the shelf %s%n", bookLocation.getKey(), bookLocation.getValue());
        }
    }
}
