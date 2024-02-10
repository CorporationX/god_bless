package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Book {
    private static void removeBook(Map<Book, String>map, String title, String author, Integer year) {
        Book bookRemove = new Book(title, author, year);

        map.remove(bookRemove);

    }

    @Getter
    @Setter
    private String title;
    @Setter
    @Getter
    private String author;
    @Getter
    @Setter
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
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
