package school.faang.WesterosLibrary;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Book {
    private final String title;
    private final String author;
    private final int year;
}

