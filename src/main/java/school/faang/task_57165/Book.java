package school.faang.task_57165;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Book {
    private static final String BOOK_INFORMATION = "The book \"%s\" (%d) by author %s";

    private String title;
    private String author;
    private int year;

    @Override
    public String toString() {
        return String.format(BOOK_INFORMATION, getTitle(), getYear(), getAuthor());
    }
}
