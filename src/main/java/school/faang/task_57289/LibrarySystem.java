package school.faang.task_57289;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;


@Slf4j
public class LibrarySystem {
    private final Map<Book, String> locationBook;

    public LibrarySystem() {
        this.locationBook = new HashMap<>();
    }

    public void addBook(@NonNull String title, @NonNull String author, int year,
                        @NonNull String location) {
        if (title.isBlank() || author.isBlank() || location.isBlank()) {
            throw new IllegalArgumentException("Title, author or location cannot be empty");
        }
        Book book = new Book(title, author, year);
        locationBook.put(book, location);
        log.info(String.format("Book: " + book + " added to shelf: " + location));

    }

    public void removeBook(@NonNull String title, @NonNull String author, int year) {
        if (title.isBlank() || author.isBlank()) {
            System.out.println("Title or author cannot be empty");
            return;
        }
        Book book = new Book(title, author, year);
        if (locationBook.remove(book) != null) {
            log.info(String.format("%s delete.", book));
        } else {
            log.info("Book not found");
        }
    }

    public String findBook(@NonNull String title, @NonNull String author, int year) {
        if (title.isBlank() || author.isBlank()) {
            throw new IllegalArgumentException("Title or author cannot be empty");
        }
        Book book = new Book(title, author, year);
        return locationBook.getOrDefault(book, String.format("%s  not found.", book));
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> books : locationBook.entrySet()) {
            System.out.printf("\t %s to shelf: s%s \n", books.getKey(), books.getValue());
        }
    }
}
