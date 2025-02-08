package bjs257097;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@Getter
@Slf4j
public class LibrarySystem {
    private final Map<Book, String> booksToPlaces = new HashMap<>();
    private Logger logger = LoggerFactory.getLogger(LibrarySystem.class);

    protected void addBook(String title, String author, int year, String location) {
        if (!title.isBlank() && !author.isBlank() && year != 0 && !location.isBlank()) {
            booksToPlaces.put(new Book(title, author, year), location);
        }
    }

    protected void removeBook(String title, String author, int year) {
        if (!title.isBlank() && !author.isBlank() && year != 0) {
            booksToPlaces.remove(new Book(title, author, year));
        }
    }

    protected String findBook(String title, String author, int year) {
        String place = booksToPlaces.get(new Book(title, author, year));
        if (place != null) {
            logger.info("Book found in the library in: {}", place);
            return place;
        } else {
            logger.info("Book not found");
            return null;
        }
    }

    protected void printAllBooks() {
        booksToPlaces.forEach((book, place) -> logger.info("Book: {}, place: {}", book, place));
    }
}
