package school.faang.westeroslibrary;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Slf4j
@Getter
public class LibrarySystem {
    private final Map<Book, String> bookLocations = new HashMap<>();

    public Book addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        this.bookLocations.put(book, location);
        return book;
    }

    public boolean removeBook(String title, String author, int year) {
        Book expectedBook = new Book(title, author, year);
        return this.bookLocations.keySet()
                .removeIf(book -> book.equals(expectedBook));
    }

    public String findBook(String title, String author, int year) {
        Book expectedBook = new Book(title, author, year);
        return this.bookLocations.entrySet().stream()
                .filter(book -> book.getKey().equals(expectedBook))
                .findFirst().orElseThrow(() -> new NoSuchElementException("Book was not found")).getValue();
    }

    public void printAllBooks() {
        log.info("Books - [{}]", this.bookLocations);
    }
}
