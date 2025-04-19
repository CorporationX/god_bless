package school.faang.bjs2_69851;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class LibrarySystem {
    private final Map<Book, String> storage = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        var book = new Book(title, author, year);
        storage.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        var book = new Book(title, author, year);
        storage.remove(book);
    }

    public void findBook(String title, String author, int year) {
        var book = new Book(title, author, year);
        var location = storage.get(book);
        if (location == null) {
            log.warn("Книга отсутствует в библиотеке!");
        } else {
            log.info("{}, лежит в: {}", book, location);
        }
    }

    public void printAllBooks() {
        if (storage.isEmpty()) {
            log.info("В библиотеке отсутствуют книги");
            return;
        }

        for (Map.Entry<Book, String> entry : storage.entrySet()) {
            log.info("{} лежит в {}", entry.getKey(), entry.getValue());
        }
    }
}