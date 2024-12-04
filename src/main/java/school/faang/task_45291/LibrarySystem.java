package school.faang.task_45291;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static Map<Book, String> books = new HashMap<>();

    public static void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        books.put(book, location);
        System.out.println("Book was added");
    }

    public static void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (books.remove(new Book(title, author, year)) == null) {
            System.out.println("There is no such book in library");
        } else {
            System.out.println("Book was succesfully deleted");
        }
    }

    public static void findBook(String title, String author, int year) {
        String book = books.get(new Book(title, author, year));
        if (book != null) {
            System.out.println("Book was found. Position is " + book);
        } else {
            System.out.println("Book is not found");
        }
    }

    public static void printAllBooks() {
        for (var book : books.entrySet()) {
            System.out.println(book.getKey() + " is on position: " + book.getValue());
        }
    }
}
