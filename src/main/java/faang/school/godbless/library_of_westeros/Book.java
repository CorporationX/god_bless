package faang.school.godbless.library_of_westeros;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if (author.isEmpty()) {
            throw new IllegalArgumentException("Author: Firstname Lastname be empty");
        }
        if (year < 0) {
            throw new IllegalArgumentException("Year cannot be negative");
        }

        this.title = title;
        this.author = author;
        this.year = year;
    }
}
