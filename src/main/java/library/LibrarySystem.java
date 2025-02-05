package library;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static final Map<Book, String> BOOKS = new HashMap<>();

    public static void addBook(String title, String author, int year, String location) {
        BOOKS.put(new Book(title, author, year), location);
    }

    public static void removeBook(String title, String author, int year) {
        BOOKS.remove(new Book(title, author, year));
    }

    public static void findBook(String title, String author, int year) {
        System.out.println(BOOKS.getOrDefault(new Book(title, author, year), "Book not found"));
    }

    public static void printAllBooks() {
        BOOKS.forEach((book, location) -> System.out.println(book + ", shelf number: " + location));
    }
}


