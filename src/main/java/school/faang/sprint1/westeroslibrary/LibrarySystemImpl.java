package school.faang.sprint1.westeroslibrary;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * In-memory implementation of {@link LibrarySystem}.
 */
public class LibrarySystemImpl implements LibrarySystem {

    /**
     * Internal storage mapping a book to its location.
     */
    private final Map<Book, String> books = new HashMap<>();


    @Override
    public String addBook(String title, String author, int year, String location) {
        validateBookData(title, author, year);
        Book book = new Book(title, author, year);
        books.put(book, location);
        System.out.println("Book added: " + book);
        return location;
    }

    @Override
    public String removeBook(String title, String author, int year) {
        validateBookData(title, author, year);
        String oldLocation = books.remove(new Book(title, author, year));
        if (oldLocation == null) {
            throw new IllegalArgumentException("Book not found.");
        }
        System.out.println("Book removed: " + new Book(title, author, year));
        return oldLocation;
    }

    @Override
    public String findBook(String title, String author, int year) {
        validateBookData(title, author, year);
        return Optional.ofNullable(books.get(new Book(title, author, year)))
            .orElseThrow(() -> new IllegalArgumentException("Book not found."));
    }

    @Override
    public void printAllBooks() {
        System.out.println("All books:");
        books.forEach(
            (book, location) -> System.out.println(book + " is located at " + location));
    }

    private void validateBookData(String title, String author, int year) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title should not be blank.");
        }
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Author should not be blank.");
        }
        if (year <= 0) {
            throw new IllegalArgumentException("Year should be greater than 0.");
        }
    }

}
