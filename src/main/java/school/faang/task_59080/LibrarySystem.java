package school.faang.task_59080;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    public static final Map<Book, String> map = new HashMap<>();

    public static void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        map.put(book, location);
        System.out.println(book.title() + " added in " + location);
    }

    public static boolean removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        System.out.println(book.title() + " removed!");
        return map.remove(book) != null;
    }

    public static void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (map.containsKey(book)) {
            System.out.println("The book is found in " + map.get(book));
        } else {
            System.out.println("The book wasn't found.");
        }
    }

    public static void printAllBooks() {
        System.out.println("\nList of all books");
        for (Map.Entry<Book, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }


}
