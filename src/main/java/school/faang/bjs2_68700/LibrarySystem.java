package school.faang.bjs2_68700;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LibrarySystem {
    private Map<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        library.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        library.remove(new Book(title, author, year));
    }

    public String findBook(String title, String author, int year) {
        return Optional.ofNullable(library.get(new Book(title, author, year))).orElseGet(() -> "Not found");
    }

    public void printAllBooks() {
        library.forEach((key, value) -> System.out.printf("%s  bookshelf № %s  \n", key, value));
    }
}
