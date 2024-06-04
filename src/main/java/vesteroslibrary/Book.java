package vesteroslibrary;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Data
@AllArgsConstructor
public record Book(String title, String author, String year) {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(year, book.year);
    }

}
