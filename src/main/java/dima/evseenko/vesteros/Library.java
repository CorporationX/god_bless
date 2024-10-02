package dima.evseenko.vesteros;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<Book, String> booksMap = new HashMap<>();

    public void addBook(Book book, String shelf) {
        if (book == null || shelf == null)
            throw new IllegalArgumentException("book or shelf cannot be null");

        booksMap.put(book, shelf);
    }

    public void deleteBook(Book book) {
        if(book == null)
            throw new IllegalArgumentException("book cannot be null");

        booksMap.remove(book);
    }

    public void deleteBook(String title, String author, int releaseYear) {
        if(title == null || author == null || releaseYear < 0)
            throw new IllegalArgumentException("title or author or releaseYear cannot be null");

        deleteBook(new Book(title, author, releaseYear));
    }

    public String findBook(Book book) {
        if(book == null)
            throw new IllegalArgumentException("book cannot be null");

        return booksMap.get(book);
    }

    public String findBook(String title, String author, int releaseYear) {
        if(title == null || author == null || releaseYear < 0)
            throw new IllegalArgumentException("title or author or releaseYear cannot be null");

        return findBook(new Book(title, author, releaseYear));
    }

    public void printBooks() {
        booksMap.forEach((book, shelf) -> System.out.println(book + ": " + shelf));
    }
}
