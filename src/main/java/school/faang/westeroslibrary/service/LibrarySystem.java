package school.faang.westeroslibrary.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import school.faang.westeroslibrary.entity.Book;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
public class LibrarySystem {
    private final Map<Book, String> bookLocation;

    public void addBook(String title, String author, int year, String location) {
        bookLocation.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        bookLocation.remove(new Book(title, author, year));
    }

    public Book findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (bookLocation.containsKey(book)) {
            log.info("Location of the {}: {}", book, bookLocation.get(book));
            return book;
        } else {
            log.warn("{} not found in the library.", book);
            return null;
        }
    }

    public void printAllBooks() {
        log.info("All library books:");
        for (Map.Entry<Book, String> entry : bookLocation.entrySet()) {
            log.info("{} location: {}", entry.getKey(), entry.getValue());
        }
    }
}
