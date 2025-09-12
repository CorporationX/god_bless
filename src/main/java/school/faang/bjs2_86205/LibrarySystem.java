package school.faang.bjs2_86205;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LibrarySystem {
    private final Map<Book, String> bookLocations = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(
                Objects.requireNonNull(title, "Title cannot be null"),
                Objects.requireNonNull(author, "Author cannot be null"),
                year
        );
        bookLocations.put(book, Objects.requireNonNull(location, "Location cannot be null"));
    }

    public boolean removeBook(String title, String author, int year) {
        Book book = new Book(
                Objects.requireNonNull(title, "Title cannot be null"),
                Objects.requireNonNull(author, "Author cannot be null"),
                year
        );
        return bookLocations.remove(book) != null;
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(
                Objects.requireNonNull(title, "Title cannot be null"),
                Objects.requireNonNull(author, "Author cannot be null"),
                year
        );
        return bookLocations.getOrDefault(book, "Книга не найдена");
    }

    public boolean containsBook(String title, String author, int year) {
        Book book = new Book(
                Objects.requireNonNull(title, "Title cannot be null"),
                Objects.requireNonNull(author, "Author cannot be null"),
                year
        );
        return bookLocations.containsKey(book);
    }

    public void printAllBooks() {
        if (bookLocations.isEmpty()) {
            System.out.println("В библиотеке нет книг");
            return;
        }

        for (Map.Entry<Book, String> entry : bookLocations.entrySet()) {
            System.out.printf("Книга: %s; расположение: %s%n",
                    entry.getKey(), entry.getValue());
        }
    }
}