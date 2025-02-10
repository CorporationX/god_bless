package BJS2_57238;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final HashMap<Book, String> books = new HashMap<>();

    public void addBook(@NonNull String title, @NonNull String author, int year, @NonNull String location) {
        if (title.isBlank() || author.isBlank() || year < 0 || location.isBlank()) {
            throw new IllegalArgumentException("Invalid input");
        }

        Book book = new Book(title, author, year);
        books.putIfAbsent(book, location);
    }

    public void removeBook(String title, String author, int year) {
        if (title.isBlank() || author.isBlank() || year < 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        Book book = new Book(title, author, year);
        books.remove(book);
    }

    public void findBook(String title, String author, int year) {
        if (title.isBlank() || author.isBlank() || year < 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        Book book = new Book(title, author, year);
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            if (entry.getKey().equals(book)) {
                System.out.println(entry.getValue());
                return;
            }
        }

        System.out.println("Книга не найдена");
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
