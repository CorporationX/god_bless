package school.faang;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class LibrarySystem {
    private final Map<Book, String> books = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book newBook = new Book(title, author, year);
        books.put(newBook, location);
    }

    public void removeBook(String title, String author, int year) {
        Book bookToRemove = new Book(title, author, year);
        books.remove(bookToRemove);
    }

    public String findBook(String title, String author, int year) {
        Book bookToFind = new Book(title, author, year);
        String location = books.get(bookToFind);
        if (location == null) {
            throw new NoSuchElementException("No book found");
        }
        return location;
    }

    public void printAllBooks() {
        System.out.println(books);
    }
}
