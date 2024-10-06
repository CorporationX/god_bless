package org.example.app;

import org.example.model.Book;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<Book, String> books = new HashMap<>(Map.of(
            new Book("title1", "author1", 1905), "place1",
            new Book("title2", "author2", 1922), "place2",
            new Book("title3", "author3", 1913), "place3",
            new Book("title4", "author4", 1908), "place4",
            new Book("title5", "author5", 1903), "place5",
            new Book("title6", "author6", 1907), "place6",
            new Book("title7", "author7", 1919), "place7"
    ));

    public static void addBook(Book book, String placeOfBook) {
        if (placeOfBook == null || placeOfBook.isEmpty()) {
            throw new IllegalArgumentException("place of the book is empty");
        } else {
            books.put(book, placeOfBook);
        }
    }

    public static void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        books.remove(book);
    }

    public static String findBookPlace(String title, String author, int year) {
        Book findingBook = new Book(title, author, year);
        String placeOfTheFindingBook = books.get(findingBook);

        if (placeOfTheFindingBook == null) {
            throw new IllegalArgumentException(
                    "book is not found by " +
                            title + ", " + author + ", " + year
            );
        } else {
            return placeOfTheFindingBook;
        }
    }

    public static void getAllBooks() {
        for (Map.Entry<Book, String> entryBook : books.entrySet()) {
            Book currentBook = entryBook.getKey();
            System.out.println(
                    currentBook.getTitle() + ", " +
                    currentBook.getAuthor() + ", " +
                    currentBook.getYear() + ": " +
                    entryBook.getValue());
        }
    }
}
