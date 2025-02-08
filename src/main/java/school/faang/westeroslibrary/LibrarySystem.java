package school.faang.westeroslibrary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private Map<Book, String> library = new HashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(LibrarySystem.class);

    public void addBook(String title, String author, int year, String location) {
        if (title == null || author == null) {
            throw new IllegalArgumentException("Fill the title or author field!");
        } else {
            Book book = new Book(title, author, year);
            library.put(book, location);
        }
    }

    public boolean removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            library.remove(book);
            logger.info("{} successfully removed", book);
            return true;
        } else {
            logger.warn("Not possible to remove unexisting book: {}", book);
            return false;
        }
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            String location = library.get(book);
            logger.info("Book found: {} at '{}'", book, location);
            return location;
        } else {
            logger.warn("{} not found.", book);
            return null;
        }
    }

    public void printAllBooks() {
        if (library.isEmpty()) {
            logger.info("No books in the library.");
        }
        library.forEach((key, value) -> {
            logger.info("{}, {}", key, value);
        });
    }
}
