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
        log.info(String.format("Книга \"%s\" добавлена на полку %s\n", book, location));
    }

    public void removeBook(String title, String author, int year) {
        Book bookToRemove = new Book(title, author, year);
        if (library.remove(bookToRemove) != null) {
            log.info(String.format("Книга \"%s\" удалена из библиотеки.\n", bookToRemove));
        } else {
            log.info(String.format("Книга \"%s\" не найдена в библиотеке.\n", bookToRemove));
        }
    }

    public Optional<Book> findBook(String title, String author, int year) {
        Book bookToFind = new Book(title, author, year);
        Optional<String> location = Optional.ofNullable(library.get(bookToFind));

        location.ifPresentOrElse(
                loc -> log.info(String.format("Книга \"%s\" найдена на полке %s.%n", title, loc)),
                () -> log.info(String.format("Книга \"%s\" не найдена в библиотеке.%n", title))
        );

        return location.isPresent() ? Optional.of(bookToFind) : Optional.empty();
    }

    public void printAllBooks() {
        if (library.isEmpty()) {
            log.info("Библиотека пуста.\n");
            return;
        }

        System.out.println("Список всех книг в библиотеке:");
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            log.info(String.format("\"%s\" - полка: %s.\n", entry.getKey(), entry.getValue()));
        }
    }
}
