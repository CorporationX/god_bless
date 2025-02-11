package BJS2_57238;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final HashMap<Book, String> books = new HashMap<>();

    public String addBook(@NonNull String title, @NonNull String author, int year, @NonNull String location) {
        if (!validateBookParams(title, author, year, location)) {
            throw new IllegalArgumentException("Invalid input");
        }

        Book book = new Book(title, author, year);
        if (books.containsKey(book)) {
            throw new IllegalArgumentException("Такая книга уже есть");
        }
        books.put(book, location);
        return location;
    }

    public String removeBook(String title, String author, int year) {
        if (!validateBookParams(title, author, year, "something")) {
            throw new IllegalArgumentException("Invalid input");
        }

        Book book = new Book(title, author, year);
        if (!books.containsKey(book)) {
            throw new IllegalArgumentException("Такой книги нет");
        }
        books.remove(book);
        return "Книга удалена";
    }

    public void findBook(String title, String author, int year) {
        if (title.isBlank() || author.isBlank() || year < 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        Book book = new Book(title, author, year);
        if (books.containsKey(book)) {
            System.out.println(books.get(book));
            return;
        }

        System.out.println("Книга не найдена");
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private boolean validateBookParams(String title, String author, int year, String location) {
        return !title.isBlank() && !author.isBlank() && year >= 0 && !location.isBlank();
    }
}
