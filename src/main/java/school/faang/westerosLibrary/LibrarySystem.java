package school.faang.westerosLibrary;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Slf4j
@Getter
public class LibrarySystem {
    private final Map<Book, String> bookLocations;

    public LibrarySystem() {
        bookLocations = new HashMap<>();
    }

    public Book addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        bookLocations.put(book, location);
        return book;
    }

    public void removeBook(String title, String author, int year) {
        bookLocations.keySet()
                .removeIf(book -> book.getTitle().equals(title) || book.getAuthor().equals(author)
                        || book.getYear() == year);
    }

    public Book findBook(String title, String author, int year) {
        return bookLocations.keySet().stream()
                .filter(book -> book.getTitle().equals(title) && book.getAuthor().equals(author)
                        && book.getYear() == year)
                .findFirst().orElseThrow(() -> new NoSuchElementException("Book was not found"));
    }

    public void printAllBooks() {
        log.info("Books - [{}]", bookLocations);
    }
}
