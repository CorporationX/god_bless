package school.faang.task_45365;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    Map<Book, String> books = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        books.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        books.remove(book);
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (books.containsKey(book)) {
            System.out.println("Location: " + books.get(book));
        } else {
            System.out.println("Book is not found");
        }
    }

    public void printAllBooks() {
        for (var entry : books.entrySet()) {
            System.out.println("Book: " + entry.getKey() + ", location: " + entry.getValue());
        }
    }
}
