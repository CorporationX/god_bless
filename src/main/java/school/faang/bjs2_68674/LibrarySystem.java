package school.faang.bjs2_68674;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class LibrarySystem {
    Map<Book, String> books = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        this.books.put(book, location);
        log.info("Book added: {} in location: {}", book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (this.books.containsKey(book)) {
            this.books.remove(book);
            log.info("Book removed: {}", book);
        } else {
            log.warn("Attempted to remove book not found in the library: {}", book);
        }
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (this.books.containsKey(book)) {
            log.info("Book: {} found in location: {}", book, this.books.get(book));
        } else {
            log.warn("Book not found: {}", book);
        }
    }

    public void printAllBooks() {
        for (Book book : this.books.keySet()) {
            log.info("Printing book: {} in location: {}", book, this.books.get(book));
        }
    }
}