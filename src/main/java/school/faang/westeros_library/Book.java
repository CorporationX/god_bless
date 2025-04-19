package school.faang.westeros_library;

import lombok.Data;

@Data
public class Book {
    private final String title;
    private final String author;
    private final int year;

    @Override
    public String toString() {
        return "Title: " + title +
                ", author: " + author +
                ", year: " + year;
    }
}