package school.faang.library;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Book {
    private final String title;
    private final String author;
    private final int year;
}
