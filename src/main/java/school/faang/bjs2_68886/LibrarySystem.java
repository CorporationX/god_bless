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

    public Book findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = booksWithLocations.get(book);
        if (location == null) {
            log.warn("Книгк {} не найдена", book);
        }
        return book;
    }

    public void printAllBooks() {
        for (Entry<Book, String> entry : booksWithLocations.entrySet()) {
            log.info("Книга: {}, Где: {}", entry.getKey().getTitle(), entry.getValue());
        }
    }
}
