package school.faang.bjs2_86053;

import lombok.extern.slf4j.Slf4j;

import java.time.Year;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class LibrarySystem {
    private final Map<Book, String> bookStringMap = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book newBook = new Book(title, author, year);

        // валидация
        if (title == null || author == null || location == null) {
            throw new IllegalArgumentException("Поля не могут быть null");
        }
        if (year < 0 || year > Year.now().getValue() + 1) {
            throw new IllegalArgumentException("Некорректный год");
        }

        // основная логика
        if (bookStringMap.containsKey(newBook)) {
            log.warn("Книга '{}' уже существует в библиотеке!", title);
            return;
        }

        bookStringMap.put(newBook, location);
        log.info("Книга '{}' успешно добавлена!", title);
    }

    public void removeBook(String title, String author, int year) {
        Book key = new Book(title, author, year);
        String removedLocation = bookStringMap.remove(key);

        boolean removed = (removedLocation != null);
        if (removed) {
            log.info("Книга '{}' успешно удалена из библиотеки!", title);
        } else {
            log.warn("Книга '{}' не найдена в библиотеке.", title);
        }
    }

    public void findBook(String title, String author, int year) {
        Book key = new Book(title, author, year);
        String location = bookStringMap.get(key);

        if (location != null) {
            log.info("Книга найдена: '{}' автора {} ({} год) находится в: {}", title, author, year, location);
        } else {
            log.warn("Книга '{}' автора {} ({} год) не найдена в библиотеке.", title, author, year);
        }
    }

    public void printAllBooks() {
        if (bookStringMap.isEmpty()) {
            log.info("Библтотека пуста!");
        } else {
            int num = 1;
            for (Book key : bookStringMap.keySet()) {
                String location = bookStringMap.get(key);
                System.out.println(num + ". '" + key.getTitle() + "' - " + key.getAuthor() +
                        " (" + key.getYear() + " год) [Место: " + location + "]");
                num++;
            }
        }
    }
}
