package school.faang.bjs2_79708;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class LibrarySystem {
    private Map<Book, String> bookStorage = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        bookStorage.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        String removedBook = bookStorage.remove(new Book(title, author, year));
        if (removedBook == null) {
            log.info("Book not found");
        }
    }

    public String findBook(String title, String author, int year) {
        String bookLocation = bookStorage.get(new Book(title, author, year));
        return bookLocation == null ? "Location unknown" : bookLocation;
    }

    public void printAllBooks() {
        if (!bookStorage.isEmpty()) {
            for (Map.Entry<Book, String> entry : bookStorage.entrySet()) {
                log.info("{}{}", entry.getKey().toString(), entry.getValue());
            }
        } else {
            log.info("No books available");
        }

    }
}
