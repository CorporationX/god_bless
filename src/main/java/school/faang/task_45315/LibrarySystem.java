package school.faang.task_45315;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static HashMap<Book, String> booksLocation = new HashMap<>();

    public static void addBook(String title, String author, int year, String location) {
        booksLocation.put(new Book(title, author, year), location);
    }

    public static void removeBook(String title, String author, int year) {
        booksLocation.remove(new Book(title, author, year));
    }

    public static void findBook(String title, String author, int year) {
        if (booksLocation.containsKey(new Book(title, author, year))) {
            System.out.println(booksLocation.get(new Book(title, author, year)));
        } else {
            System.out.println("Book not found");
        }
    }

    public static void printAllBooks() {
        for (Map.Entry<Book, String> book : booksLocation.entrySet()) {
            System.out.println(book.getKey() + " " + book.getValue());
        }
    }
}