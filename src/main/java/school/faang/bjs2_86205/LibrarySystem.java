package school.faang.bjs2_86205;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LibrarySystem {
    private final Map<Book, String> bookLocation = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Objects.requireNonNull(title, "Title cannot be null");
        Objects.requireNonNull(author, "Author cannot be null");
        Objects.requireNonNull(location, "Location cannot be null");

        Book book = new Book(title, author, year);
        bookLocation.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        Objects.requireNonNull(title, "Title cannot be null");
        Objects.requireNonNull(author, "Author cannot be null");

        Book book = new Book(title, author, year);
        bookLocation.remove(book);
    }

    public String findBook(String title, String author, int year) {
        Objects.requireNonNull(title, "Title cannot be null");
        Objects.requireNonNull(author, "Author cannot be null");

        Book book = new Book(title, author, year);
        return bookLocation.get(book);
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : bookLocation.entrySet()) {
            System.out.printf("Книга: %s; расположение: %s%n",
                    entry.getKey(), entry.getValue());
        }
    }
}