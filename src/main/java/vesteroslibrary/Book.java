package vesteroslibrary;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
import java.util.Objects;

@Data
@AllArgsConstructor
public class Book {

    private String title;
    private String author;
    private String year;

    public static void addBook(Map<Book, String> books, Book book, String location) {
        books.put(book, location);
    }

    public static void remove(Map<Book, String> books, String title, String author, String year) {
        books.remove(new Book(title, author, year));
    }

    public static String getBookLocation(Map<Book, String> books, String title, String author, String year) {
        return books.get(new Book(title, author, year));
    }

    public static void getAllBooks(Map<Book, String> books) {
        books.forEach((book, location) -> System.out.println(book + " " + location));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(year, book.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }
}
