package school.faang.library;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> bookLocationMap;

    public LibrarySystem() {
        bookLocationMap = new HashMap<>();
    }

    public void addBook(String title, String author, int year, String location) {
        if (location == null || location.isBlank()) {
            throw new IllegalArgumentException("Location can't be null or blank");
        }

        Book book = new Book(title, author, year);
        bookLocationMap.put(book, location);
    }


    /**
     * Deletes a book from the library by its title, author, and year of publication.
     * If a book is found in the library, it is deleted and a successful deletion message is displayed.
     * If the book is not found, a message is displayed stating that the book is missing from the library.
     *
     * @param title Is the name of the book that needs to be deleted.
     * @param author is the author of the book that needs to be deleted.
     * @param year is the year of publication of the book that needs to be deleted.
     * @see Book
     * @see #bookLocationMap
     */
    public void removeBook(String title, String author, int year) {
        Book bookToRemove = new Book(title, author, year);
        if (bookLocationMap.containsKey(bookToRemove)) {
            bookLocationMap.remove(bookToRemove);
            System.out.println("Book '" + title + "' by " + author + " (" + year + ") has been removed.");
        } else {
            System.out.println("Book '" + title + "' by " + author + " (" + year + ") not found.");
        }
    }

    /**
     * Searches for a book in the library by its title, author, and year of publication.
     * If a book is found, its location in the library is displayed.
     * If the book is not found, a message is displayed stating that the book is missing from the library.
     *
     * @param title The name of the book you need to find.
     * @param author is the author of the book that needs to be found.
     * @param year is the year of publication of the book you need to find.
     * @see Book
     * @see #bookLocationMap
     */
    public void findBook(String title, String author, int year) {
        Book bookToFind = new Book(title, author, year);
        String location = bookLocationMap.get(bookToFind);
        if (location != null) {
            System.out.println("Book '" + title + "' by " + author + " (" + year + ") is located at: " + location);
        } else {
            System.out.println("Book '" + title + "' by " + author + " (" + year + ") not found.");
        }
    }

    /**
     * Prints all books in the library along with their locations.
     * If the library is empty, a message indicating that the library is empty is displayed.
     * Otherwise, it iterates through the {@code bookLocationMap} and prints the details of each book
     * (including its title, author, year, and location).
     *
     * @see Book
     * @see #bookLocationMap
     */
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