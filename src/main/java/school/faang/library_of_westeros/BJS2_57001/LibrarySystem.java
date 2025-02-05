package school.faang.library_of_westeros.BJS2_57001;

import lombok.Getter;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

@Getter
public class LibrarySystem {

    private final Map<Book, String> books = new HashMap<>();

    public void addBook(@NonNull String title, @NonNull String author, int year, @NonNull String location) {
        books.put(new Book(title, author, year), location);
    }

    public void removeBook(@NonNull String title, @NonNull String author, int year) {
        books.remove(new Book(title, author, year));
    }

    public void findBook(@NonNull String title, @NonNull String author, int year) {
        System.out.println(books.getOrDefault(new Book(title, author, year), "Book not found"));
    }

    public void printAllBooks() {
        for (var entry : books.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

}
