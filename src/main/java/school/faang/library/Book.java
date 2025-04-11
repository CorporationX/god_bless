package school.faang.library;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Book {
    private final String title;
    private final String author;
    private final int year;
}
