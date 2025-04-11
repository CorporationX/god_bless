package school.faang.library;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Data
public class LibrarySystem {
    private final Map<Book, String> bookArchive = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        bookArchive.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        String result = bookArchive.remove(new Book(title, author, year));
        if (result == null) {
            log.info("Книги {} под авторством {} {} года отсутствует", title, author, year);
        } else {
            log.info("Книги {} под авторством {} {} года была удалена", title, author, year);
        }
    }

    public void findBook(String title, String author, int year) {
        if (bookArchive.containsKey(new Book(title, author, year))) {
            log.info("Книга {} под авторством {} {} года находится на полке {}",
                    title, author, year, bookArchive.get(new Book(title, author, year)));
        } else {
            log.info("Книги {} под авторством {} {} года нет в библиотеке", title, author, year);
        }
    }

    public void printAllBooks() {
        log.info(bookArchive.toString());
    }
}
