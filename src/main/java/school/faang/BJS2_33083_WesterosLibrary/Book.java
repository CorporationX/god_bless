package school.faang.BJS2_33083_WesterosLibrary;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Objects;

@Getter
public class Book {
    private final String title;
    private final String author;
    private final int year;

    public Book(String title, String author, int year) {
        validateString(title);
        validateString(author);
        validateYear(year);

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

    @Override
    public String toString() {
        return String.format("Book with title: '%s', its author: %s, year of publication: %d", title, author, year);
    }

    private void validateString(String string) {
        if (string == null || string.isBlank())
            throw new IllegalArgumentException("Invalid info.");
    }

    private void validateYear(int year) {
        if (year < 1564) {
            throw new IllegalArgumentException("Invalid year of publication. Must be at least 1564.");
        }
    }

}
