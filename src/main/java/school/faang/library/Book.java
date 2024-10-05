package school.faang.library;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Map;
import java.util.Objects;

@Getter
@RequiredArgsConstructor
@ToString
public class Book {
    private final String title;
    private final String author;
    private final int year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    public static void addBook(Map<Book, String> books, Book book, String location) {
        books.put(book, location);
    }

    public static void deleteBook(Map<Book, String> books, Book book) {
        books.remove(book);
        System.out.println(book + " has been deleted.");
    }

    public static void deleteBook(Map<Book, String> books, String title, String author, int year) {
        Book bookToDelete = new Book(title, author, year);
        deleteBook(books, bookToDelete);
    }

    public static String findBook(Map<Book, String> books, String title, String author, int year) {
        String bookDetails = "Title: \"" + title + "\", Author: " + author + ", Year: " + year;
        String location = books.get(new Book(title, author, year));
        if (location != null) {
            System.out.println("Location for book: " + bookDetails + ", is shelf: " + location);
        } else {
            System.out.println("The following book wat not found: " + bookDetails);
        }
        return location;
    }

    public static void listAllBooks(Map<Book, String> books) {
        System.out.printf("| %-15s | %-15s | %-15s | %-15s |%n", "Title:", "Author:", "Year:", "Shelf");
        for (Map.Entry bookEntry : books.entrySet()) {
            Book book = (Book) bookEntry.getKey();
            System.out.printf("| %-15s | %-15s | %-15s | %-15s |%n", book.getTitle(), book.getAuthor(), book.getYear(), bookEntry.getValue());
        }
    }


}
