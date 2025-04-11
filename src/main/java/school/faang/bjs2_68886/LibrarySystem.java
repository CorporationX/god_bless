package school.faang.bjs2_68886;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LibrarySystem {
    private final Map<Book, String> booksWithLocations = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        booksWithLocations.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        Book bookToBeRemoved = new Book(title, author, year);
        booksWithLocations.remove(bookToBeRemoved);
    }

    public String findBook(String title, String author, int year) {
        Book bookToBeFound = new Book(title, author, year);
        if (booksWithLocations.containsKey(bookToBeFound)) {
            return "Книга находится тут: " + booksWithLocations.get(bookToBeFound);
        }
        return "Книга не найдена";
    }

    public void printAllBooks() {
        for (Entry<Book, String> entry : booksWithLocations.entrySet()) {
            log.info("Книга: {}, Где: {}", entry.getKey().getTitle(), entry.getValue());
        }
    }
}
