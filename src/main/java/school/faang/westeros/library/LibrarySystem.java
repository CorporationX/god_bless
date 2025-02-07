package school.faang.westeros.library;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static final String EMPTY_TITLE_ERROR = "Название книги не может быть пустым!";
    private static final String EMPTY_AUTHOR_ERROR = "Имя автора должно быть заполнено!";
    private static final String EMPTY_LOCATION_ERROR = "Название полки не может быть пустым!";
    private static final String INVALID_YEAR_ERROR = "Указан некорректный год издания!";
    private static final Logger logger = LoggerFactory.getLogger(LibrarySystem.class);
    private Map<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        checkArguments(title, author, year, location);
        Book book = new Book(title, author, year);
        library.put(book, location);
        logger.info("Книга {} добавлена на полку {}", book, location);
    }

    public void removeBook(String title, String author, int year) {
        checkArguments(title, author, year);
        Book book = new Book(title, author, year);
        String location = library.remove(book);
        if (location != null) {
            logger.info("Книга {} удалена с полки {}", book, location);
            return;
        }
        logger.info("Книга {} не найдена.", book);
    }

    public void findBook(String title, String author, int year) {
        checkArguments(title, author, year);
        Book book = new Book(title, author, year);
        String location = library.get(book);
        if (location == null) {
            logger.info("Книга {} не найдена.", book);
            return;
        }
        logger.info("Книга {} находится на полке {}", book, location);
    }

    public void printAllBooks() {
        System.out.println("\nСписок книг:");
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.println("Книга: " + entry.getKey() + "\tПолка: " + entry.getValue());
        }
    }

    private void checkArguments(String title, String author, int year) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException(EMPTY_TITLE_ERROR);
        }
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException(EMPTY_AUTHOR_ERROR);
        }
        if (year <= 0) {
            throw new IllegalArgumentException(INVALID_YEAR_ERROR);
        }
    }

    private void checkArguments(String title, String author, int year, String location) {
        checkArguments(title, author, year);
        if (location == null || location.isBlank()) {
            throw new IllegalArgumentException(EMPTY_LOCATION_ERROR);
        }
    }
}
