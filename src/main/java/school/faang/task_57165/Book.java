package school.faang.task_57165;

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
        return "{Title: " + title + ", Author: " + author + ", Year: " + year + "}";
    }
}
