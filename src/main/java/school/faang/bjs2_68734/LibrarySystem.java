package school.faang.bjs2_68734;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class LibrarySystem {
    Map<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        this.library.put(book, location);
        log.info("The book {} is added at location: {}.", book, location);
    }

    public boolean removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return this.library.remove(book) != null;
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return this.library.getOrDefault(book, "The book was not found.");
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : this.library.entrySet()) {
            log.info("{} is located at {}", entry.getKey(), entry.getValue());
        }
    }
}
