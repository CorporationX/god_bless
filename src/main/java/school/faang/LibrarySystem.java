package school.faang;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LibrarySystem {
    private static final Logger logger = Logger.getLogger(LibrarySystem.class.getName());
    private static final HashMap<Book, String> bookLocation = new HashMap<>();

    public static void main(String[] args) {

        addBook("LofR", "Tolkien", 1954, "12");
        addBook("GoT", "Martin", 1996, "1232");
        addBook("Life", "Me", 2025, "72");

        removeBook("GoT", "Martin", 1996);

        findBook("Life", "Me", 2025);

        printAllBooks();
    }

    private static void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        if (bookLocation.containsKey(book)) {
            logger.log(Level.WARNING, "Book {0} already exist at location {1}.",
                    new Object[]{book, bookLocation.get(book)});
        } else {
            bookLocation.put(book, location);
            logger.log(Level.INFO, "Book added: {0} at location {1}.", new Object[]{book, location});
        }
    }

    private static void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (bookLocation.containsKey(book)) {
            bookLocation.remove(book);
            logger.log(Level.INFO, "Book deleted: {0}", book);
        } else {
            logger.log(Level.WARNING, "Book {0} not found.", book);
        }
    }

    private static void printAllBooks() {
        for (Map.Entry<Book, String> entry : bookLocation.entrySet()) {
            System.out.println("Book: " + entry.getKey() + " - Shelf: " + entry.getValue());
        }
    }

    private static void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = bookLocation.get(book);
        if (location != null) {
            System.out.println("Found Book: " + book + " at shelf: " + location);
        } else {
            System.out.println("Book: " + book + " not found");
        }
        if (location != null) {
            logger.log(Level.INFO, "Book found: {0} at location {1}.", new Object[]{book, location});
        } else {
            logger.log(Level.WARNING, "Book {0} not found.", book);
        }
    }

}
