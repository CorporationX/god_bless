package vesteroslibrary;

import java.util.Map;

public class Main {

    public static void addBook(Map<Book, String> books, Book book, String location) {
        books.put(book, location);
    }

    public static void remove(Map<Book, String> books, String title, String author, String year) {
        books.remove(new Book(title, author, year));
    }

    public static String getBookLocation(Map<Book, String> books, String title, String author, String year) {
        return books.get(new Book(title, author, year));
    }

    public static Map<Book, String> getAllBooks(Map<Book, String> books) {
        return books;
    }
}
