package school.faang.bjs243520;

import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {

    private static Map<Book, String> booksLibrary = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        booksLibrary.put(book, location);
        System.out.println(book + " added to Library: " + location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        booksLibrary.remove(book);
        System.out.println(book + " removed");

    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = booksLibrary.get(book);
        System.out.println(book + " located in Library: " + location);
    }

    public void printAllBooks() {
        booksLibrary.forEach((book, location) ->
            System.out.println(book + " is located in: " + location));
    }
}
