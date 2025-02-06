package school.faang;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    Map<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        library.put(book, location);
        System.out.println(book + " added at location " + location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            library.remove(book);
            System.out.println(book + " successfully removed!");
        } else {
            System.out.println(book + " doesn't exist");
        }
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            System.out.println(book + " found at " + library.get(book));
        } else {
            System.out.println(book + " not found!");
        }
    }

    public void printAllBooks() {
        System.out.println("\nLibrary contains the following books: ");
        for (var entry : library.entrySet()) {
            System.out.println(entry.getKey() + " is located at " + entry.getValue());
        }
    }
}
