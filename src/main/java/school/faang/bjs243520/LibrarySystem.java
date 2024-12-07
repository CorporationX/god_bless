package school.faang.bjs243520;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {

    private static final Map<Book, String> booksLibrary = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        String locationExist = booksLibrary.putIfAbsent(book, location);
        if (locationExist == null) {
            System.out.println(book + " added to Library: " + location);
        } else {
            System.out.println(book + " was already found in Library: " + locationExist);
        }
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        booksLibrary.remove(book);
        System.out.println(book + " removed");
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (booksLibrary.containsKey(book)) {
            System.out.println(book + " located in Library: " + booksLibrary.get(book));
        } else {
            System.out.println(book + " was not found!");
        }
    }

    public void printAllBooks() {
        booksLibrary.forEach((book, location) ->
            System.out.println(book + " is located in: " + location));
    }
}
