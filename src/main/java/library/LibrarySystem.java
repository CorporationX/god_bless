package library;

import java.time.Year;
import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private Map<Book, String> library = new HashMap<>();
    int currentYear = Year.now().getValue();

    public void addBook(String title, String author, int year, String location) {
        try {
            if (title == null || title.isBlank()) {
                throw new IllegalArgumentException("Title cannot be null or empty.");
            }
            if (author == null || author.isBlank()) {
                throw new IllegalArgumentException("Author cannot be null or empty.");
            }
            if (location == null || location.isBlank()) {
                throw new IllegalArgumentException("Location cannot be null or empty.");
            }
            if (year < 1500 || year > currentYear) {
                throw new IllegalArgumentException("Year must be between 1500 and " + currentYear);
            }
            Book book = new Book(title, author, year);
            library.put(book, location);
            System.out.printf("Book '%s' written by %s was added to the library, shelf number: %s \n",
                    book.getTitle(), book.getAuthor(), location);
        } catch (IllegalArgumentException e) {
            System.out.println("Error! " + e.getMessage());
        }
    }

    public void removeBook(String title, String author, int year) {
        try {
            Book book = new Book(title, author, year);
            if (library.remove(book) != null) {
                System.out.println("Removed from library: " + book);
            } else {
                System.out.println("Book not found: " + book);
            }
        } catch (Exception e) {
            System.out.println("Error! " + e.getMessage());
        }
    }

    public String findBook(String title, String author, int year) {
        if (title == null || title.isBlank() || author == null || author.isBlank()) {
            return "Invalid input: title and author must not be empty. ";
        }
        Book book = new Book(title, author, year);
        String location = library.get(book);
        return (location != null) ? "Shelf number: " + location : "Book not found";
    }

    public void printAllBooks() {
        try {
            System.out.println("All books in the library: ");
            library.forEach((book, location) -> System.out.println(book + ", shelf number: " + location));
        } catch (Exception e) {
            System.out.println("Error! " + e.getMessage());
        }
    }
}



