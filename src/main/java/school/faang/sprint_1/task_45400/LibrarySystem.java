package school.faang.sprint_1.task_45400;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static Map<Book, String> library = new HashMap<>();

    public static void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        library.put(book, location);
        System.out.println("Book added: " + book + ", her location: " + location);
    }

    public static void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (library.remove(book) != null) {
            System.out.println("Book: " + book + ", removed");
        } else {
            System.out.println("Book not found");
        }
    }

    public static void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            System.out.println("Book: " + book + ", found and is located: " + library.get(book));
        } else {
            System.out.println("Book: " + book + ", not found!");
        }
    }

    public static void printAllBooks() {
        for (var entry : library.entrySet()) {
            System.out.println("Book: " + entry.getKey() + ", her location: " + entry.getValue());
        }
    }
}