package faang.school.godbless;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@Getter

public class Book {
    private String title, author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return "book title: " + title +
                ", author: " + author +
                ", year of issue: " + year;
    }
}
