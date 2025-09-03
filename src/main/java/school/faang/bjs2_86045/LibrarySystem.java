package school.faang.bjs2_86045;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static Map<Book, String> bookLocation = new HashMap<>();

    public static void addBook(String title, String author, int year, String location) {
        bookLocation.put(new Book(title, author, year), location);
    }

    public static void removeBook(String title, String author, int year) {
        Book bookToRemove = new Book(title, author, year);
        if (bookLocation.containsKey(bookToRemove)) {
            bookLocation.remove(bookToRemove);
            System.out.println("Removed Book: " + bookToRemove);
        } else {
            System.out.println("Book not found");
        }

    }

    public static void findBook(String title, String author, int year) {
        String location;
        Book bookToFind = new Book(title, author, year);
        if (bookLocation.get(bookToFind) == null) {
            location = "not found";
        } else {
            location = bookLocation.get(bookToFind);
        }
        System.out.println(bookToFind + " location: " + location);
    }

    public static void printAllBooks() {
        for (Map.Entry<Book, String> entry : bookLocation.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
