package school.faang;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<Book, String> books;

    public Library() {
        this.books = new HashMap<>();
    }

    public void addBook(String title, String author, Integer year, String location) {
        books.put(new Book(title, author, year), location);
    }

    public void deleteBook(String title, String author, Integer year) {
        Book bookForDelete = new Book(title, author, year);
        if (books.containsKey(bookForDelete)) {
            books.remove(bookForDelete);
        } else {
            throw new IllegalArgumentException("Book not found.");
        }
    }

    public String findLocation(String title, String author, Integer year) {
        return books.get(new Book(title, author, year));
    }

    public void printAllBooks() {
        System.out.println(books);
    }
}
