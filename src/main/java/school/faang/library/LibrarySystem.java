package school.faang.library;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static final Map<Book, String> booksMap = new HashMap<>(Map.of(
            new Book("The Witcher", "Andrzej Sapkowskiy", 1993), "first shelf",
            new Book("Grok algorithms", "Aditya Bhargava", 2019), "second shelf"));

    public static void addBook(String title, String author, int year, String location) {
        booksMap.put(new Book(title, author, year), location);
    }

    public static void removeBook(String title, String author, int year) {
        Object result = booksMap.remove(new Book(title, author, year));
        if (result == null) {
            System.out.println("the book for remove was not found");
        }
    }

    public static String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (booksMap.containsKey(book)) {
            return "Place: " + booksMap.get(book);
        } else {
            return "the book was not found";
        }
    }

    public static void printAllBooks() {
        for (var book : booksMap.entrySet()) {
            System.out.println(book.getKey() + " Place: " + book.getValue());
        }
        System.out.println();
    }
}
