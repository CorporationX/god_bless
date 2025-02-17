package school.faang.sprint1.vesteros_library_57192;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private Map<Book, String> bookPlace = new HashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(LibrarySystem.class);

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        if (bookPlace.get(book) != null) {
            logger.info("Данная книга (или ее копия) уже хранится в библиотеке на месте: {}", bookPlace.get(book));
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Название книги не должно быть пустым");
        }
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Информация об авторе книги не должна быть пустой");
        }
        if (year <= 0) {
            throw new IllegalArgumentException("Год издания должен быть положительным числом");
        }
        if (location == null || location.isBlank()) {
            throw new IllegalArgumentException("Информация о местоположении книги не должна быть пустой");
        } else {
            bookPlace.put(book, location);
        }
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (bookPlace.get(book) == null) {
            System.out.println("Такая книга не обнаружена");
        } else {
            if (bookPlace.isEmpty()) {
                System.out.println("В библиотеке нет книг");
            } else {
                bookPlace.remove(book);
            }
        }

    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (!bookPlace.containsKey(book)) {
            System.out.println("Указанной книги нет в библиотеке");
        } else {
            System.out.println("Местоположение книги: " + bookPlace.get(book));
        }
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> book : bookPlace.entrySet()) {
            System.out.println("Книга: " + book.getKey() + " Местоположение: " + book.getValue());
        }
    }
}
