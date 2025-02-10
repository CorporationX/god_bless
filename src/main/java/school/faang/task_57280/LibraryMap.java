package school.faang.task_57280;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Data
public class LibraryMap {
    private final Map<Book, String> libraryMap = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book newBook = new Book(title, author, year);
        if (libraryMap.containsKey(newBook)) {
            log.info("Book like this already exists = {}", newBook);
            return;
        }
        libraryMap.put(newBook, location);
    }

    public void removeBook(String title, String author, int year) {
        Book newBook = new Book(title, author, year);
        if (!libraryMap.containsKey(newBook)) {
            log.info("Book like this isn't in library = {}", newBook);
            return;
        }
        libraryMap.remove(newBook);
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String result = libraryMap.get(book);
        log.info(Objects.requireNonNullElse(result,
                "There is no book like this!"));
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : libraryMap.entrySet()) {
            log.info("Book: {}, Placement: {}", entry.getKey(), entry.getValue());
        }
    }
}
