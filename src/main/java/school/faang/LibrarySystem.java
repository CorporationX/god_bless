package school.faang;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> bookLocationMap;

    public LibrarySystem() {
        bookLocationMap = new HashMap<>();
    }

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        bookLocationMap.put(book, location);
    }


    // Deletes a book by title, author, and year of publication
    public void removeBook(String title, String author, int year) {
        Book bookToRemove = new Book(title, author, year);
        if (bookLocationMap.containsKey(bookToRemove)) {
            bookLocationMap.remove(bookToRemove);
            System.out.println("Book '" + title + "' by " + author + " (" + year + ") has been removed.");
        } else {
            System.out.println("Book '" + title + "' by " + author + " (" + year + ") not found.");
        }
    }

    // Searches for a book by title, author, and year of publication and displays its location
    public void findBook(String title, String author, int year) {
        Book bookToFind = new Book(title, author, year);
        String location = bookLocationMap.get(bookToFind);
        if (location != null) {
            System.out.println("Book '" + title + "' by " + author + " (" + year + ") is located at: " + location);
        } else {
            System.out.println("Book '" + title + "' by " + author + " (" + year + ") not found.");
        }
    }

    // Displays a complete list of all books and their location
    public void printAllBooks() {
        if (bookLocationMap.isEmpty()) {
            System.out.println("The library is empty.");
        } else {
            System.out.println("Books in the library:");
            for (Map.Entry<Book, String> entry : bookLocationMap.entrySet()) {
                System.out.println("Book: " + entry.getKey() + ", Location: " + entry.getValue());
            }
        }
    }
}
