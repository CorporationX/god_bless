package school.faang.task_45316;

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
        return "Book: " + title + " " + year + " year";
    }
}
