package school.faang.BJS2_33083_WesterosLibrary;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
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

    private void validateString(String string) {
        if (string == null || string.isBlank())
            throw new IllegalArgumentException("Invalid info.");
    }

    private void validateYear(int year) {
        if (year < 1564) {
            throw new IllegalArgumentException("Invalid year of publication. Must be at least 1564.");
        }
    }

    @Override
    public String toString() {
        return String.format("Book title: %s, author: %s, year: %s", title, author, year);
    }
}
