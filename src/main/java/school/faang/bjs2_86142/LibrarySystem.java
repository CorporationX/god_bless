package school.faang.bjs2_86142;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class LibrarySystem {

    private final Map<Book, String> booksLocations = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        booksLocations.put(book, location);
        log.info("Добавлена новая книга: {}", book.getTitle());
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String delete = booksLocations.remove(book);
        if (delete == null) {
            log.info("Такой книги не существует");
        } else {
            log.info("Удалена книга: {}, она находилась в {}", book.getTitle(), delete);
        }
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = booksLocations.get(book);
        if (location == null) {
            log.info("Книга {} не найдена", book.getTitle());
        } else {
            log.info("Книга {} найдена, ее местоположение {}", book.getTitle(), location);
        }
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : booksLocations.entrySet()) {
            log.info("{} -> {}", entry.getKey(), entry.getValue());
        }
    }
}
