package school.faang.task_57289;

import lombok.Data;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

@Data
public class LibrarySystem {
    Map<Book, String> locationBook = new HashMap<>();

    public void addBook(@NonNull String title, @NonNull String author, int year,
                        @NonNull String location) {
        if (title.isBlank() || author.isBlank() || location.isBlank()) {
            System.out.println("Title, author or location cannot be empty");
            return;
        }
        Book book = new Book(title, author, year);
        locationBook.put(book, location);
        System.out.println("Book: " + book + " added to shelf: " + location);
    }

    public void removeBook(@NonNull String title, @NonNull String author, int year) {
        if (title.isBlank() || author.isBlank()) {
            System.out.println("Title or author cannot be empty");
            return;
        }
        Book book = new Book(title, author, year);
        if (locationBook.remove(book) != null) {
            System.out.println(book + " delete.");
        } else {
            System.out.println("Book not found");
        }
    }

    public String findBook(@NonNull String title, @NonNull String author, int year) {
        if (title.isBlank() || author.isBlank()) {
            return "Title or author cannot be empty";
        }
        Book book = new Book(title, author, year);
        return locationBook.getOrDefault(book, "Book: " + book + " not found.");
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> books : locationBook.entrySet()) {
            System.out.println("Book: " + books.getKey() + " to shelf: " + books.getValue());
        }
    }
}
