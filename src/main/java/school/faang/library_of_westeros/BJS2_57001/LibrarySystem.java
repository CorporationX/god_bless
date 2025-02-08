package school.faang.library_of_westeros.BJS2_57001;

import lombok.Getter;
import lombok.NonNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Year;
import java.util.HashMap;
import java.util.Map;

@Getter
public class LibrarySystem {
    private static final Logger LOGGER = LoggerFactory.getLogger(LibrarySystem.class);

    private final Map<Book, String> books = new HashMap<>();

    public void addBook(@NonNull String title, @NonNull String author, int year, @NonNull String location) {
        validateTitle(title);
        validateAuthor(author);
        validateYear(year);
        validateLocation(location);

        books.put(new Book(title, author, year), location);

        LOGGER.info("Added book {} to library system", title);
    }

    public void removeBook(@NonNull String title, @NonNull String author, int year) {
        validateTitle(title);
        validateAuthor(author);
        validateYear(year);

        books.remove(new Book(title, author, year));

        LOGGER.info("Removed book {} from library system", title);
    }

    public void findBook(@NonNull String title, @NonNull String author, int year) {
        validateTitle(title);
        validateAuthor(author);
        validateYear(year);

        String result = books.getOrDefault(new Book(title, author, year), "Book not found");
        System.out.println(result);

        if (result.equals("Book not found")) {
            LOGGER.info("Book not found");
        } else {
            LOGGER.info("Found book {} in library system", result);
        }
    }

    public void printAllBooks() {
        for (var entry : books.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        LOGGER.info("Printing all books in library system");
    }

    private static void validateYear(int year) {
        if (year < 0 || year > Year.now().getValue()) {
            LOGGER.error("Year must be between 0 and {}", Year.now().getValue());
            throw new IllegalArgumentException(year + " must be between 0 and " + Year.now().getValue());
        }
    }

    private static void validateLocation(String location) {
        if (location.isBlank()) {
            LOGGER.error("Location is blank");
            throw new IllegalArgumentException("Location cannot be blank");
        }
    }

    private static void validateAuthor(String author) {
        if (author.isBlank()) {
            LOGGER.error("Author is blank");
            throw new IllegalArgumentException("Author cannot be blank");
        }
    }

    private static void validateTitle(String title) {
        if (title.isBlank()) {
            LOGGER.error("Title is blank");
            throw new IllegalArgumentException("Title cannot be blank");
        }
    }
}
