package school.faang.bjs2_68674;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
public class LibrarySystem {
    HashMap<Book, String> books = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        books.computeIfAbsent(book, k -> location);
        log.info("Book added: {} in location: {}", book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (books.containsKey(book)) {
            books.remove(book);
            log.info("Book removed: {}", book);
        } else {
            log.warn("Attempted to remove book not found in the library: {}", book);

        }
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (books.containsKey(book)) {
            log.info("Book: {} found in location: {}", book, books.get(book));
        } else {
            log.warn("Book not found: {}", book);
        }
    }

    public void printAllBooks() {
        for (Book book : books.keySet()) {
            log.info("Printing book: {} in location: {}", book, books.get(book));
        }
    }
}