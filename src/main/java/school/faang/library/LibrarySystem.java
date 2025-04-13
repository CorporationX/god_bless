package school.faang.library;

import lombok.extern.slf4j.Slf4j;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class LibrarySystem {
    private Book bookTemp;
    private final Map<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        bookTemp = buildBook(title, author, year);
        library.put(bookTemp, location);
    }

    public void removeBook(String title, String author, int year) {
        bookTemp = buildBook(title, author, year);
        library.remove(bookTemp);
    }

    public void findBook(String title, String author, int year) {
        bookTemp = buildBook(title, author, year);
        String destination = library.get(bookTemp);

        if (destination == null) {
            log.info("Книга: \"{}\" не найдена.", bookTemp.getTitle());
        } else {
            log.info("Книга: \"{}\" найдена. Местонахождение: {}", bookTemp.getTitle(), destination);
        }
    }

    public void printAllBooks() {
        log.info("Перечень всех книг в библиотеке:");
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            log.info("Книга: \"{}\". Местонахождение: {}", entry.getKey().getTitle(), entry.getValue());
        }
    }

    private Book buildBook(String title, String author, int year) {
        return bookTemp = Book.builder()
                .title(title)
                .author(author)
                .year(year)
                .build();
    }
}
