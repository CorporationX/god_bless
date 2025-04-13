package school.faang.library;

import lombok.extern.slf4j.Slf4j;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class LibrarySystem {
    private final Map<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        library.put(buildBook(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {

        if (library.remove(buildBook(title, author, year)) == null) {
            log.info("Не найдена книга: \"{}\".",
                    buildBook(title, author, year).getTitle());
        } else {
            log.info("Книга: \"{}\" удалена.",
                    buildBook(title, author, year).getTitle());
        }
    }

    public void findBook(String title, String author, int year) {
        String destination = library.get(buildBook(title, author, year));

        if (destination == null) {
            log.info("Не найдена книга: \"{}\".",
                    buildBook(title, author, year).getTitle());
        } else {
            log.info("Найдена книга: \"{}\". Местонахождение: {}",
                    buildBook(title, author, year).getTitle(), destination);
        }
    }

    public void printAllBooks() {
        log.info("Перечень всех книг в библиотеке:");
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            log.info("Книга: \"{}\". Местонахождение: {}", entry.getKey().getTitle(), entry.getValue());
        }
    }

    private Book buildBook(String title, String author, int year) {
        return Book.builder()
                .title(title)
                .author(author)
                .year(year)
                .build();
    }
}
