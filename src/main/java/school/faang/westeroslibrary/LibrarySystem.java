package school.faang.westeroslibrary;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class LibrarySystem {
    private final Map<Book, String> bookLocations = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        this.bookLocations.put(book, location);
        log.info("Книга добавлена: '{}' автора {} ({} г.) на полку: {}",
                title, author, year, location);
    }

    public void removeBook(String title, String author, int year) {
        Book bookToRemove = new Book(title, author, year);
        if (this.bookLocations.remove(bookToRemove) != null) {
            log.info("Книга '{}' автора {} ({} г.) удалена!", title, author, year);
        } else {
            log.warn("Ошибка удаления! Книга '{}' не найдена ", title);
        }
    }

    public void findBook(String title, String author, int year) {
        Book bookToFind = new Book(title, author, year);
        String location = this.bookLocations.get(bookToFind);
        if (location != null) {
            log.info("Найдена книга: '{}' автора {} ({} г.) - полка: {}",
                    title, author, year, location);
        } else {
            log.info("Книга не найдена: '{}' автора {} ({} г.)", title, author, year);
        }
    }

    public void printAllBooks() {
        if (this.bookLocations.isEmpty()) {
            log.info("Библиотека пуста");
            return;
        }
        this.bookLocations.forEach((book, location) ->
                log.info("{} - находится на полке: {}", book, location));
    }
}
