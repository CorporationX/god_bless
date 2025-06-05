package school.faang.module1.bjs2_79647;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@AllArgsConstructor
public class LibrarySystem {

    private final Map<Book, String> bookLocations;

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        bookLocations.put(book, location);
        log.info("Book added: {}. Location: {}", book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String removedLocation = bookLocations.remove(book);
        if (removedLocation != null) {
            log.info("Book removed: {}", book);
        } else {
            log.warn("Book not found for removal: {}", book);
        }
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = bookLocations.get(book);
        if (location != null) {
            log.info("Book found: {} location: {}", book, location);
        } else {
            log.warn("Book not found: {}", book);
        }
    }

    public void printAllBooks() {
        if (bookLocations.isEmpty()) {
            log.info("The library is empty.");
        } else {
            log.info("List of all books in the library:");
            bookLocations.forEach((book, location) -> log.info("{} location: {}", book, location));
        }
    }
}
