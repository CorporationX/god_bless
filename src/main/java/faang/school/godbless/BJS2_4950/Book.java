package faang.school.godbless.BJS2_4950;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
import java.util.Objects;

@Data
@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private int year;

    public static void addBook(Map<Book, String> books, Book book, String shelf) {
        books.put(book, shelf);
    }

    public static void deleteBook(Map<Book, String> books, Book book) {
        books.remove(book);
    }

    public static String findBookByName(Map<Book, String> books, Book book) {
        if (book != null && books.containsKey(book)) {
            return books.get(book);
        }
        return null;
    }

    public static void printAllBooks(Map<Book, String> books) {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            System.out.println(entry.getKey().getTitle() + " " + entry.getKey().getAuthor() + " " +
                    entry.getKey().getYear() + ": " + entry.getValue());
        }
    }

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
}
