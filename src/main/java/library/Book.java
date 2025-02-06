package library;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private int year;

    @Override
    public String toString() {
        return String.format("Book: %s, author: %s, year: %d", title, author, year);
    }
}

