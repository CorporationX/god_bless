package school.faang.library;


import lombok.ToString;

import java.time.Year;
import java.util.Objects;

@ToString
public class Book {
    private final String title;
    private final String author;
    private final int year;


    public void validateTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title can't be null or blank");
        }
    }

    public void validateAuthor(String author) {
        if (author == null) {
            throw new IllegalArgumentException("Author can't be null");
        }
    }

    public void validateYear(int year) {
        if (year > Year.now().getValue()) {
            throw new IllegalArgumentException("The year can't be more than "  + Year.now().getValue());
        }
        if (year <= 0) {
            throw new IllegalArgumentException("A year cannot be negative or equal to zero.");
        }
    }

    public Book(String title, String author, int year) {
        validateTitle(title);
        validateAuthor(author);
        validateYear(year);

        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Book book = (Book) obj;
        return Objects.equals(year, book.year) && Objects.equals(title, book.title)
                && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(title, author, year);
    }
}