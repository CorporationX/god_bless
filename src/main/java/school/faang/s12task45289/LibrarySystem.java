package school.faang.s12task45289;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class LibrarySystem {

    private final Map<Book, String> bookLocation;

    public LibrarySystem() {
        bookLocation = new HashMap<>();
    }

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        bookLocation.put(book, location);
        log.info("the book have added");
    }

    public void findBook(String title, String author, int year) {

        for (Map.Entry<Book, String> entry : bookLocation.entrySet()) {
            if ((entry.getKey().getTitle().equalsIgnoreCase(title))
                    && (entry.getKey().getAuthor().equalsIgnoreCase(author))
                    && (entry.getKey().getYear() == year)) {
                log.info("the book have found");
                return;
            }
        }
    }

    public void removeBook(String title, String author, int year) {
        Book bookToRemove = new Book(title, author, year);

        if (bookLocation.containsKey(bookToRemove)) {
            bookLocation.remove(bookToRemove);
            log.info("the book have removed: {}", bookToRemove);
        } else {
            log.info("the book have not found: {}", bookToRemove);
        }
    }

    public void printAllBooks() {
        bookLocation.forEach((book, location) -> {
            System.out.println(book + " is located at " + location);
        });
    }
}