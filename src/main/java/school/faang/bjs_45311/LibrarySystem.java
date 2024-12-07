package school.faang.bjs_45311;

import lombok.extern.java.Log;
import school.faang.bjs_45311.exception.BookNotFoundException;

import java.util.HashMap;
import java.util.Map;

@Log
public class LibrarySystem {
    private final Map<Book, String> booksWithLocation;

    public LibrarySystem() {
        booksWithLocation = new HashMap<>();
    }

    public void addBook(String title, String author, int year, String location) throws IllegalArgumentException {
        Book book;

        if (checkLocation(location)) {
            book = buildBook(title, author, year);
            booksWithLocation.put(book, location);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void removeBook(String title, String author, int year) throws IllegalArgumentException {
        Book book = buildBook(title, author, year);
        booksWithLocation.remove(book);
    }

    public String getBookLocation(String title, String author, int year) throws BookNotFoundException {
        Book book = buildBook(title, author, year);
        String location = booksWithLocation.get(book);

        if (location == null || location.isEmpty()) {
            throw new BookNotFoundException("Не найдена книга: " + book);
        }

        return location;
    }

    public void printAllBooks() {
        booksWithLocation.forEach((key, value) -> log.info(key.toString() + ":"
                + value));
    }

    private boolean checkBooksParameters(String title, String author) {
        return title != null && !title.isEmpty() && author != null && !author.isEmpty();
    }

    private boolean checkLocation(String location) {
        return location != null && !location.isEmpty();
    }

    private Book buildBook(String title, String author, int year) {
        if (checkBooksParameters(title, author)) {
            return new Book(title, author, year);
        }
        throw new IllegalArgumentException();
    }
}
