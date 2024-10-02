package dima.evseenko.vesteros;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<Book, String> booksMap = new HashMap<>();

    public void addBook(Book book, String shelf) {
        validateBook(book);

        if (shelf == null)
            throw new IllegalArgumentException("shelf cannot be null");

        booksMap.put(book, shelf);
    }

    public void deleteBook(Book book) {
        validateBook(book);
        booksMap.remove(book);
    }

    public void deleteBook(String title, String author, int releaseYear) {
        deleteBook(new Book(title, author, releaseYear));
    }

    public String findBook(Book book) {
        validateBook(book);
        return booksMap.get(book);
    }

    public String findBook(String title, String author, int releaseYear) {
        return findBook(new Book(title, author, releaseYear));
    }

    private void validateBook(Book book) {
        if(book == null)
            throw new IllegalArgumentException("book cannot be null");
        if(book.getTitle() == null)
            throw new IllegalArgumentException("book title cannot be null");
        if(book.getAuthor() == null)
            throw new IllegalArgumentException("book author cannot be null");
        if(book.getReleaseYear() < 0)
            throw new IllegalArgumentException("book release year cannot be negative");
    }

    public void printBooks() {
        booksMap.forEach((book, shelf) -> System.out.println(book + ": " + shelf));
        System.out.println();
    }
}
