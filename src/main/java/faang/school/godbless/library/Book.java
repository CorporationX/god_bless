package faang.school.godbless.library;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
public class Book {
    private String title;
    private String author;
    private int year;

    @Override
    public String toString() {
        return "Name: " + title + " Author: " + author + " year: " + year;
    }
}
