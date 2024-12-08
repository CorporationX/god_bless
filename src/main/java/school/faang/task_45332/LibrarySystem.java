package school.faang.task_45332;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> books = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        if (!books.containsKey(book)) {
            books.put(book, location);
            System.out.println("The Book: " + book + " added to the: " + location);
        } else {
            System.out.println("The Book not added");
        }
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        books.remove(book);
        System.out.println("The Book removed: " + book + " from the shelf: " + books.get(book));
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (books.containsKey(book)) {
            String location = books.get(book);
            System.out.println("The Book: " + book + " found in the: " + location);
        } else {
            System.out.println("The Book not found");
        }
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            System.out.println("The Book: " + entry.getKey() + " lies on the: " + entry.getValue());
        }
    }
}
