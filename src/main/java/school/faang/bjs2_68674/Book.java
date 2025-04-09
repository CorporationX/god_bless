package school.faang.bjs2_68674;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EqualsAndHashCode
@ToString
public class Book {
    private final String title;
    private final String author;
    private final int year;
    private static final int MIN_YEAR = 0;

    public Book(String title, String author, int year) {
        if (title == null || author == null) {
            log.error("Attempted to create Book with null title or author");
            throw new IllegalArgumentException("Title and author cannot be null");
        }
        if (year < MIN_YEAR) {
            log.error("Attempted to create Book with negative year: {}", year);
            throw new IllegalArgumentException("Year cannot be negative: " + year);
        }
        this.year = year;
        this.title = title;
        this.author = author;
    }
}