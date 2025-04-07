package school.faang.library_westeros;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
public class LibrarySystem {
    private final Map<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        library.put(book, location);
        log.info("Книга \"{}\" добавлена на полку {}", book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book bookToRemove = new Book(title, author, year);
        if (library.remove(bookToRemove) != null) {
            log.info("Книга \"{}\" удалена из библиотеки.", bookToRemove);
        } else {
            log.info("Книга \"{}\" не найдена в библиотеке.", bookToRemove);
        }
    }

    public Optional<Book> findBook(String title, String author, int year) {
        Book bookToFind = new Book(title, author, year);
        String location = library.get(bookToFind);

        if (location == null) {
            log.info("Книга \"{}\" не найдена в библиотеке.", title);
            return Optional.empty();
        }
        log.info("Книга \"{}\" найдена на полке {}.", title, location);
        return Optional.of(bookToFind);
    }

    public void printAllBooks() {
        if (library.isEmpty()) {
            log.info("Библиотека пуста.");
            return;
        }

        System.out.println("Список всех книг в библиотеке:");
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            log.info("\"{}\" - полка: {}.", entry.getKey(), entry.getValue());
        }
    }
}
