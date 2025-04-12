package school.faang.book;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {

    private final HashMap<String, Book> bookHashMap = new HashMap<>();

    Logger logger = LoggerFactory.getLogger(LibrarySystem.class);


    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        bookHashMap.put(location, book);
        logger.info("Book add " + bookHashMap);
    }

    public void removeBook(Book book) {
        bookHashMap.remove(book);
        logger.info("Book delete " + bookHashMap);
    }

    public Book findBook(String title, String author, int year) {
        return bookHashMap.values()
                .stream()
                .filter(book -> book.getTitle().equals(title))
                .filter(book -> book.getAuthor().equals(author))
                .filter(book -> book.getYear() == year)
                .findFirst()
                .orElseGet(() -> {
                    logger.error("Book not Found");
                    return null;
                });
    }

    public void printAllBooks() {
        for (Map.Entry<String, Book> entry : bookHashMap.entrySet()) {
            logger.info("Map all Book " + entry);
        }
    }
}
