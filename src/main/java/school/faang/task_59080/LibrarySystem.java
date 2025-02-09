package school.faang.task_59080;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static final Map<Book, String> map = new HashMap<>();

    public static void addBook(@NonNull String title, @NonNull String author, int year,
                               @NonNull String location) {
        Book book = new Book(title, author, year);
        map.put(book, location);
        System.out.println(book.title() + " added in " + location);
    }

    public static boolean removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        boolean removed = map.remove(book) != null;
        if (removed) {
            System.out.println(book.title() + " removed!");
        }
        return removed;
    }

    public static void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        System.out.println(map.containsKey(book)
                ? ("The book is found in " + map.get(book)) : "The book wasn't found.");
    }

    public static void printAllBooks() {
        System.out.println("\nList of all books");
        for (Map.Entry<Book, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }


}
