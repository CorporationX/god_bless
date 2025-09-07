package school.faang.bjs286024;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static final Map<Book, String> books = new HashMap<>();

    public static void addBook(String title, String author, int year, String location) {
        books.put(new Book(title, author, year), location);
    }

    public static void removeBook(String title, String author, int year) {
        Book bookToRemove = new Book(title, author, year);
        books.remove(bookToRemove);
    }

    public static void findBook(String title, String author, int year) {
        Book bookToFind = new Book(title, author, year);
        System.out.println(books.getOrDefault(bookToFind, "Book is not found!"));
    }

    public static void printAllBooks() {
        for (Map.Entry<Book, String> book : books.entrySet()) {
            System.out.println(book + " is located here:" + book.getValue());
        }
    }
}
