package school.faang.BJS2_57129;

import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class LibrarySystem {

    private static final Logger log = LoggerFactory.getLogger(LibrarySystem.class);

    private final Map<Book, String> books = new HashMap<>();

    /**
     * Метод добавления книги в библиотеку
     *
     * @see LibrarySystem#findBook(String, String, int)
     * @param location - место нахождения книги в библиотеке
     */
    public void addBook(String title, String author, int year, String location) {
        books.put(new Book(title, author, year), location);
        log.info(String.format("Книга с названием \"%s\" под авторством: %s - добавлена в библиотеку", title, author));
    }

    /**
     * Метод удаления книги из библиотеки
     *
     * @see LibrarySystem#findBook(String, String, int)
     */
    public void removeBook(String title, String author, int year) {
        books.remove(new Book(title, author, year));
        log.info(String.format("Книга с названием \"%s\" - удалена из библиотеки", title));
    }

    /**
     * Метод определения местонахождения книги в библиотеке
     *
     * @param title  - наименование книги
     * @param author - автор книги
     * @param year   -  год издания
     */
    public String findBook(String title, String author, int year) {
        log.info(String.format("Осуществлен поиск местонахождения книги %s", title));
        return books.getOrDefault(new Book(title, author, year), "Книга с наименованием \""
                + title + "\" отсутствует в библиотеке!");

    }

    /**
     * Метод, отображающий все книги в библиотеке с указанием местоположения
     */
    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            System.out.println(entry.getKey() + ", полка: " + entry.getValue());
        }
    }

}
