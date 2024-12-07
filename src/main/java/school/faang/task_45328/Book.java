package school.faang.task_45328;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
public class Book {
    private final String title;
    private final String author;
    private final int year;

    @Override
    public String toString() {
        return title + ", " + author;
    }
}
