package school.faang.bjs2_79708;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static Map<Book, String> bookStorage = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        bookStorage.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        bookStorage.remove(new Book(title, author, year));
    }

    public String findBook(String title, String author, int year) {
        String bookLocation = bookStorage.get(new Book(title, author, year));
        return bookLocation == null ? "Location unknown" : bookLocation;
    }

    public void printAllBooks() {
        if (!bookStorage.isEmpty()) {
            for (Map.Entry<Book, String> entry : bookStorage.entrySet()) {
                System.out.println(entry.getKey().toString() + entry.getValue());
            }
        } else {
            System.out.println("No books available");
        }

    }
}
