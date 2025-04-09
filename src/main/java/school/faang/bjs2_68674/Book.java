package school.faang.bjs2_68674;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
@ToString
public class Book {
    private final String title;
    private final String author;
    private final int year;

    public Book(String title, String author, int year) {
        if (title == null || author == null) {
            log.error("Attempted to create Book with null title or author");
            throw new IllegalArgumentException("Title and author cannot be null");
        }
        if (year < 0) {
            log.error("Attempted to create Book with negative year: {}", year);
            throw new IllegalArgumentException("Year cannot be negative: " + year);
        }
        this.year = year;
        this.title = title;
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }
}