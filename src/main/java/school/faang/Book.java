package school.faang;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private int year;
    private final Map<LibrarySystem.Book, String> bookLocationMap = new HashMap<>();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(bookLocationMap, book.bookLocationMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }


    public void findBook(String summary, String polBrosnan, int i) {
    }
    public void printAllBooks() {
        System.out.println("Каталог библиотеки:");
        bookLocationMap.forEach((book, location) ->
                System.out.printf("%-40s → Полка: %s%n", book, location));
    }
}