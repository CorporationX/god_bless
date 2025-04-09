package school.faang.bjs2_68677;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class LibrarySystem {
    private final Map<Book, String> books = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        books.put(createBook(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        books.remove(createBook(title, author, year));
    }

    public String findBook(String title, String author, int year) {
        return books.getOrDefault(createBook(title, author, year), null);
    }

    public void printAllBooks() {
        books.forEach((book, location) -> log.info("Книга {} находится на полке {}", book, location));
    }

    private Book createBook(String title, String author, int year) {
        return Book.builder().title(title).author(author).year(year).build();
    }
}
