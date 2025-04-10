package school.faang;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode
@RequiredArgsConstructor
@ToString
public class Book {
    private final String title;
    private final String author;
    private final int year;
}

