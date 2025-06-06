package school.faang.bjs2_79659;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> bookLocations = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        bookLocations.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String shelf = bookLocations.remove(book);
        if (shelf == null) {
            System.out.println("Книга не найдена в системе");
        }
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return bookLocations.getOrDefault(book, "книга не найдена");
    }

    public void printAllBooks() {
        bookLocations.forEach((book, shelf) -> {
            System.out.printf("%s, shelf: %s\n", book, shelf);
        });
    }
}
